package com.appWeb.myApp.controller;



import com.appWeb.myApp.controller.jwt.JwtRequest;
import com.appWeb.myApp.controller.jwt.JwtResponse;
import com.appWeb.myApp.domain.Produto;

import com.appWeb.myApp.exception.ProdutoException;
import com.appWeb.myApp.service.IserviceProduto;
import com.appWeb.myApp.util.JwtTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerApp {


    @Autowired
     IserviceProduto iserviceProduto;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Autowired
    private UserDetailsService userDetailsService;

    private void authenticate(String username, String password){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtRequest authRequest){


        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

         String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));

    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "index";
    }



    @GetMapping("/")
    @PostMapping("/")
    public String root(Model model) throws ProdutoException {
        List<Produto> allProducts = iserviceProduto.getAll();
        model.addAttribute("produtos",allProducts);

        return "index";

    }

    @GetMapping("/produtos/{id}")
    public String recuperarProdutos(Model model, @PathVariable("id") Long id){

        Produto produtoById = iserviceProduto.getProdutoById(id);

        model.addAttribute("produto",produtoById);
        return "cadastrarProdutos";

    }

    @RequestMapping("/checkout")
    public String checkout(){
        return "checkout";
    }


    @GetMapping("/produtos/cadastrar")
    public String cadastrarProdutosTemplates(Model model){
        return "cadastrarProdutos";
    }

    @PostMapping("/produtos/cadastrar")
    public String cadastrarProdutos(Model model, Produto produto){
        iserviceProduto.cadastrarProduto(produto);
        return "redirect:/";
    }

    @ExceptionHandler(ProdutoException.class)
    public ModelAndView handleException(HttpServletRequest request, ProdutoException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", exception.getMessage());
        mav.addObject("url", exception.getUrl());
        mav.setViewName("error");
        return mav;
    }

}
