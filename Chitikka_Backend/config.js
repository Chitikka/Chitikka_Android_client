const mysql = require('mysql2');

const connectionPool = mysql.createPool({
    connectionLimit: 10,
    host: 'localhost',
    user: 'root',
    password: 'password123',
    database: 'Chitikka',
})

module.exports = connectionPool;