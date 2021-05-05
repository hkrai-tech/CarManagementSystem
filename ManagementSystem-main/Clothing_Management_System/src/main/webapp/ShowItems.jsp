<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@page import="com.trishul.IndividualItem.IndividualItem"%>


     <%@page import="java.util.ArrayList"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">



</head>
<body class='bg-gray-800'>



<!-- Fontswesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/js/all.min.js"></script>
     
    <header class="text-gray-100 bg-gray-900 body-font shadow w-full">
        <div class="container mx-auto flex flex-wrap p-5 flex-col md:flex-row items-center">
            <nav class="flex lg:w-2/5 flex-wrap items-center text-base md:ml-auto">
                <a
                    class="mr-5 hover:text-gray-900 cursor-pointer border-b border-transparent hover:border-indigo-600"  href="Buy">My Dashboard</a>
                
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



	<!-- component -->
<div class="text-gray-900 bg-gray-800">
    <div class="p-4 flex">
        <h1 class="text-3xl" style="color:white;">
            The Stock
        </h1>
    </div>
    <div class="px-3 py-4 flex justify-center">
        <table class="w-full text-md bg-white shadow-md rounded mb-4">
            <tbody>
                <tr class="border-b">
                    <th class="text-left p-3 px-5">Brand</th>
                    <th class="text-left p-3 px-5">Color</th>
                    <th class="text-left p-3 px-5">in Stock</th>
                    <th class="text-left p-3 px-5">Price</th>
                   
                    <th></th>
                </tr>
                
                <% ArrayList<IndividualItem>arr=new ArrayList<IndividualItem>();
	 
	 		arr=(ArrayList<IndividualItem>)request.getAttribute("data");
	 
	 
	for(IndividualItem d : arr){ %>
                <form action="EditItem" method="post">
                <tr class="border-b hover:bg-orange-100 bg-gray-100">
                    <td class="p-3 px-5"><input type="text" value="<%=d.getBrand()%>" name='brand'" class="bg-transparent"></td>
                    <td class="p-3 px-5"><input type="text" value="<%=d.getColor()%>" name='color'" class="bg-transparent"></td>
                     <td class="p-3 px-5"><input type="text" value="<%=d.getInstock()%>" name='instock'" class="bg-transparent"></td>
                      <td class="p-3 px-5"><input type="text" value="<%=d.getPrice()%>" name='price'" class="bg-transparent"></td>
                      <%if(session.getAttribute("user").toString().equals("Customer"))
					{ %>
                    <td class="p-3 px-5 flex justify-end"><button type="button" class="mr-3 text-sm bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline"><a href="ReduceStock?itemname=<%=d.getBrand()%>">Purchase</a></button></td>
                	<%}
                      else{%>
                    	  
                     	   <td class="p-3 px-5 flex justify-end"><button type="submit" class="mr-3 text-sm bg-blue-500 hover:bg-blue-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline">Edit</button><button type="button" class="text-sm bg-red-500 hover:bg-red-700 text-white py-1 px-2 rounded focus:outline-none focus:shadow-outline"><a href="DeleteItem?itemname=<%=d.getBrand()%>">Delete</a></button></td>
                      <%}%>
                	
                	
                </tr>
               </form> 
       <%}%>
       
            </tbody>
            
        </table>
    </div>
</div>
	

	

</body>
</html>