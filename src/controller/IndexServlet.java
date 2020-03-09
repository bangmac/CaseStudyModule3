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
import java.util.List;

import static javax.swing.text.html.HTML.Tag.HEAD;

@WebServlet(name = "IndexServlet", urlPatterns = "/home")
public class IndexServlet extends HttpServlet {
    private ProductService productService;

    public void init() {
        productService = new ProductService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        String productType3 = "đồ dùng cá nhân";
        List<Product> hotProduct = productService.productListHot(productType3);
        request.setAttribute("hotProduct", hotProduct);

=======
//>>>>>>> fc8a57f93bc0616d5f6e891eceeb08530fbc9b49
        String action;
        action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                String nameProductSearch = request.getParameter("Search");
                break;
<<<<<<< HEAD
            case "signup":
                System.out.println("sign up");
                String userName = request.getParameter("name");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                System.out.println(userName + " " + password + " " + email);
                if (productService.checkUserName(userName)) {
                    System.out.println("tai khoan da ton tai");
                    request.setAttribute("message", "Tai khoan da ton tai");
                } else {
                    User userNew = new User(userName, password, email);
                    productService.insertUser(userNew);
                    request.setAttribute("message", "Dang ky thanh cong");
                }

                break;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("main/index.jsp");
        dispatcher.forward(request, response);
=======
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
//>>>>>>> fc8a57f93bc0616d5f6e891eceeb08530fbc9b49
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
