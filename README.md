Car controller:
GET ("/cars") - returns the list of all cars
GET ("/cars/{id}") - returns info of one car
GET ("/cars/new") - returns the form to register new car
POST ("/cars") - sends car information to database, redirects to "/cars"
GET ("/cars/{id}/edit") - returns the form to edit existing car
PATCH ("/cars/{id}") - updates car information to database, redirects to "/cars"
DELETE ("/cars/{id}") - deletes car, redirects to "/cars"

Customer controller:
GET ("/customers") - returns the list of all customers
GET ("/customers/{id}") - returns info of one customer
GET ("/customers/new") - returns the form to register new customer
POST ("/customers") - sends customer information to database, redirects to "/customers"
GET ("/customers/{id}/edit") - returns the form to edit existing customer
PATCH ("/customers/{id}") - updates customer information to database, redirects to "/customers"
DELETE ("/customers/{id}") - deletes customer, redirects to "/customers"

Rent controller:
GET ("/rents") - returns the list of all rents
GET ("/rents/{id}") - returns info of one rent
GET ("/rents/new") - returns the form to register new rent
POST ("/rents") - sends rent information to database, redirects to "/rents"