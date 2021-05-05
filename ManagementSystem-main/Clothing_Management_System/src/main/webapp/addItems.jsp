<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
</head>
<body class="bg-gray-800">

		
<!-- component -->
<div class="bg-grey-lighter min-h-screen flex flex-col">
            <div class="container max-w-sm mx-auto flex-1 flex flex-col items-center justify-center px-2">
                <div class="bg-white px-6 py-8 rounded shadow-md text-black w-full">
                    <h1 class="mb-8 text-3xl text-center">Add Items</h1>
                    <form action="AddItem" method="post">
                    <input 
                        type="text"
                        class="block border border-grey-light w-full p-3 rounded mb-4"
                        name="BrandName"
                        placeholder="Brand Name" />

                    <input 
                        type="text"
                        class="block border border-grey-light w-full p-3 rounded mb-4"
                        name="Color"
                        placeholder="Color" />

                    <input 
                        type="text"
                        class="block border border-grey-light w-full p-3 rounded mb-4"
                        name="instock"
                        placeholder="Total in Stock" />
                    <input 
                        type="text"
                        class="block border border-grey-light w-full p-3 rounded mb-4"
                        name="Price"
                        placeholder="Price" />

                    <input
                        type="submit"
                        class="w-full text-center py-3 rounded bg-green-400 text-white hover:bg-green-300 focus:outline-none my-1"
                    value="Add">
					</form>
					
					 <button
                        type="submit"
                        class="w-full text-center py-3 rounded bg-green-400 text-white hover:bg-green-300 focus:outline-none my-1"
                    ><a href="home.jsp">Done Adding</a></button>
                    <div class="text-center text-sm text-grey-dark mt-4">
                        
                    </div>
                </div>

                
            </div>
        </div>
		
		

</body>
</html>