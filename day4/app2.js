const express = require('express');
const mongoose = require('mongoose');

const bcrypt = require('bcrypt');
const User = require('./models/user');

const PORT = 3000;
const app= express();
app.use(express.json());

const mongoURI = 'mongodb+srv://pranavidraju:pranavidraju2510@cluster0.xm8kz.mongodb.net/'
mongoose.connect(mongoURI)
        .then(()=> console.log('Mongodb connected.....'))
        .catch(err=> console.log(err));


app.get('/',(req,res) =>{
    res.send('MongoDB connected');
    });

app.get('/api/users', async (req,res)=>{
try{
const users = await User.find();
res.json(users);
} catch(err){
    res.status(500).send(err);
}
});
                                             
app.post('/api/users',async (req,res)=>{
            try{
                const userData = req.body;
                const user = await User.create(userData);
                res.status(201).json(user);
            } catch(err){
                res.status(500).send(err);
            }
 });

        


app.get('/',(req,res) =>{
    res.send('Hello World to Express');
});

// app.get('/api/users',(req,res) =>{
//     const users = [
//         {id:1,uname:'Pranavi'},
//         {id:2, uname:'Domma'}
//     ]
//     res.json(users);
// });

app.listen(PORT,() =>{
    console.log(`Server Startedon ${PORT}`);
});