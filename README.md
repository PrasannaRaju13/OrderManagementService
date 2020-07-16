# OrderManagementService
OrderServcie and OrderItem Management


POST
http://localhost:8083/orderItems/orderItems

request:
{"orderItemId":"1","productCode":"s123","productName":"sssss","quantity":"34"}


GET:
http://localhost:8083/orderItems/order-items


response:
{
    "success": true,
    "data": [
        {
            "orderItemId": 1,
            "productCode": "s123",
            "productName": "ggggg",
            "quantity": 33
        }
    ],
    "result": {
        "info": "Request processed successfully."
    }
}

2nd service:

http://localhost:8084/orders/order

request

{
	"orderId":1,
	"customerName":"RR",
	"orderDate":"07/05/2020",
	"shippingAddress":"asdasdas",
	"orderItemId":"1",
	"total":"2000"
}

response:
{
    "success": true,
    "data": {
        "status": "SUCCESS",
        "statusCode": 200,
        "keys": null,
        "key": 1
    },
    "result": {
        "info": "Request processed successfully."
    }
}


GET:

http://localhost:8084/orders/orders-list

{
    "success": true,
    "data": [
        {
            "orderId": 1,
            "customerName": "GK",
            "orderDate": "07/05/2020",
            "shippingAddress": "asdasdas",
            "total": 2000,
            "orderItemId": 0
        }
    ],
    "result": {
        "info": "Request processed successfully."
    }
}


