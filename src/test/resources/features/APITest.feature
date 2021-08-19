Feature: Request example

    @API
    Scenario: GET from endpoint test
        Given a GET request is sent to the https://api.github.com endpoint
        Then a 200 status code is received

     @API
     Scenario: Validate item quantity in response
        Given a GET request is sent to the https://jsonplaceholder.typicode.com/ endpoint
        Then 10 items are present in the /users endpoint