package controller;

import model.product.Product;
import model.user.User;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/home")
public class IndexServlet extends HttpServlet {
    private ProductService productService;

    public void init() {
        productService = new ProductService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                String nameProductSearch = request.getParameter("Search");
                break;
            case "dangky":
                String userName=request.getParameter("name");
                String password=request.getParameter("password");
                String email =request.getParameter("email");
                if (productService.checkUserName(userName)){
                    System.out.println("tai khoan da ton tai");
//                    request.setAttribute("message","Tai khoan da ton tai");
                }else {
                    User userNew=new User(userName,password,email);
                    productService.insertUser(userNew);
//                    request.setAttribute("message","Dang ky thanh cong");
                }
                RequestDispatcher dispatcher=request.getRequestDispatcher("main/index.jsp");
                dispatcher.forward(request,response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("index");
        String productType = "đồ cho trẻ";
        List<Product> productList = productService.productList(productType);
        request.setAttribute("productList", productList);
        String productType1 = "đồ dùng cá nhân";
        List<Product> personalCare = productService.productList(productType1);
        request.setAttribute("personalCare", personalCare);
        String productType2 = "đồ ăn";
        List<Product> foodList = productService.productList(productType2);
        request.setAttribute("foodList", foodList);
        String productType3 = "đồ dùng cá nhân";
        List<Product> hotProduct = productService.productListHot(productType3);
        request.setAttribute("hotProduct", hotProduct);
        RequestDispatcher dispatcher = request.getRequestDispatcher("main/index.jsp");
        dispatcher.forward(request, response);

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
//        String productSearch
    }

}
