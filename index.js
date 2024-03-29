'use strict'

const express = require('express')
const bodyParser = require('body-parser')
const mongoose = require('mongoose')

const Product = require('./models/product')
const app = express()
const port = process.env.PORT || 3000 

app.use(bodyParser.urlencoded({ extended:false}))
app.use(bodyParser.json())

app.get('/api/product', (req, res) => {
    res.send(200, {productStored})
    Product.find()
})

app.get('/api/product/:productId', (req, res) => {
    let productId = req.params.productId

    Product.findById(productId, (err, product) => {
        if(err) return res.status(500).send({message:`Error al salvar en la base de datos: ${err}`})
        if(!product) return res.status(404).send({message: `El producto no existe`})
        
        res.status(200).send({product: product})
    })
})

app.post('/api/product', (req, res) => {
    console.log('POST /api/product')
    console.log(req.body)

    let product = new Product()
    product.name = req.body.name
    product.price = req.body.price
    product.save((err, productStored)=>{
        if(err) res.status(500).send({message:`Error al salvar en la base de datos: ${err}`})
        
        res.status(200).send({product: productStored})
    })
})

app.put('/api/product/:productId', (req, res) => {
    let productId = req.params.productId
    let update = req.body
    Product.findByIdAndUpdate(productId, update, (err, productUpdated)=>{
        if(err) res.status(500).send({message:`Error al salvar en la base de datos: ${err}`})
        res.status(200).send({product: productUpdated})
    })
})

app.delete('/api/product/:productId', (req, res) => {
    let productId = req.params.productId

    Product.findById(productId, (err, product) => {
        if(err) return res.status(500).send({message:`Error al borrar el producto: ${err}`})
        product.remove(err => {
            if(err) return res.status(500).send({message:`Error al borrar el producto: ${err}`})
            res.status(200).send({message: 'El producto ha sido eliminado'})
        })
    })
})

mongoose.connect('mongodb://localhost:27017/shop', (err, res)=>{
    if(err) throw err
    console.log('Conexion a la base de datos establecida...')

    app.listen(port, () => {
        console.log(`API REST corriendo en http://localhost:${port}`)
    })
})