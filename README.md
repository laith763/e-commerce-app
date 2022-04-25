# e-commerce-app
# API Design
| HTTP Method | URL Path | Status Code | Description |
|:........:|:.......:|:.........:|:.......:|
| GET | api/v0/customers | 200(Ok) | Get all the customers |
GET
api/v0/customers/{id}
200(Ok)
Get customer by id
POST
api/v0/customers
200(created)
Add a new customer
PUT
api/v0/customers/{id}
200(Ok)
Update customer info
DELETE
api/v0/customers/{id}
200(Ok)
Delete customer by id
GET
api/v0/orders
200(Ok)
Get all the orders
GET
api/v0/orders/{id}
200(Ok)
Get order by id
POST
api/v0/orders
200(Created)
Add a new order
PUT
api/v0/orders/{id}
200(ok)
Update order info
DELETE
api/v0/orders/{id}
200(Ok)
Delete order by id
GET
api/v0/products
200(Ok)
Get all the products 
GET
api/v0/products
200(Ok)
Get product by id
POST
api/v0/products
200(Created)
Add a new product
PUT
api/v0/products/{id}
200(Ok)
Update product by id
DELETE
api/v0/products/{id}
200(Ok)
Delete product by id





# Testing 
i used postman to test all the Api's


# Database
i used postgresql to storage the data in it


# API
i build three model the customer, order and product
and declear all request Methods ( get , post , put , delete)
