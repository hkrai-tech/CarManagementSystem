<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body class="bg-gray-900">

<%if(session.getAttribute("user").toString().equals("Customer")){%>

<!-- Dark Header component -->
 <!-- Fontswesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/js/all.min.js"></script>
     
    <header class="text-gray-100 bg-gray-900 body-font shadow w-full">
        <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
            
            
            <div class="flex order-first lg:order-none lg:w-1/5 title-font font-medium items-center lg:items-center lg:justify-center-left mb-4 md:mb-0">
                <a  class="bg-indigo-700 hover:bg-indigo-500 text-white ml-4 py-2 px-3 rounded-lg" href="Logout">
                   Logout
                </a>
            </div>
        </div>
    </header>


<!-- header end -->
<%} %>

<%if(session.getAttribute("user").toString().equals("Agent")){%>

<!-- Dark Header component -->
 <!-- Fontswesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/js/all.min.js"></script>
     
    <header class="text-gray-100 bg-gray-900 body-font shadow w-full">
        <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
            <nav class="flex lg:w-2/5 flex-wrap items-center text-base md:ml-auto">
                <a
                    class="mr-5 hover:text-gray-900 cursor-pointer border-b border-transparent hover:border-indigo-600"  href="home.jsp">Dashboard</a>
                <a
                    class="mr-5 hover:text-gray-900 cursor-pointer border-b border-transparent hover:border-indigo-600" href="ShowCategories">My Categories</a>
                <a class="mr-5 hover:text-gray-900 cursor-pointer border-b border-transparent hover:border-indigo-600" href="CategoryForm.jsp">Add Category</a>
                <a
                    class="hover:text-gray-900 cursor-pointer border-b border-transparent hover:border-indigo-600" href="DeleteCategory.jsp">Delete Category</a>
            </nav>
            <a
                class="flex order-first lg:order-none lg:w-1/5 title-font font-medium items-center lg:items-center lg:justify-center mb-4 md:mb-0">
                <img src="https://pazly.dev/logo.png" style="height: 40px; margin-top: 10px; margin-bottom: 10px;"
                    alt="logo">

                <span class="ml-3 text-xl">pazly.dev</span>
            </a>
            <div class="lg:w-2/5 inline-flex lg:justify-end ml-5 lg:ml-0">
                <a  class="bg-indigo-700 hover:bg-indigo-500 text-white ml-4 py-2 px-3 rounded-lg" href="Logout">
                   Logout
                </a>
            </div>
        </div>
    </header>


<!-- header end -->

<%} %>




<%
			ArrayList<String>arr=new ArrayList<String>();
			arr=(ArrayList<String>)request.getAttribute("arr");
			
			for(int i=0;i<arr.size();i++)
			{%>
			
	<!-- component -->
<div class="container flex mx-auto w-full items-center justify-center">

   <ul class="flex flex-col  p-4">
    <a href="ShowItem?category=<%=arr.get(i)%>">
        <li class="border-gray-400 flex flex-row mb-2">
          <div class="select-none cursor-pointer bg-gray-200 rounded-md flex flex-1 items-center p-4  transition duration-500 ease-in-out transform hover:-translate-y-4 hover:shadow-lg">
            <div class="flex flex-row rounded-md w-10 h-10 bg-gray-300 justify-center items-center mr-4">💧</div>
            <div class="flex pl-1 mr-16">
              <div class="font-medium"><%=arr.get(i)%></div>
             
            </div>
            
          </div>
        </li>
         <a>   
           
    </ul>
    
  </div>
		<%} arr.clear(); %>	

</body>
</html>