class User{
    constructor(uname,email){
        this.uname = uname;
        this.email = email;
    }
    greet(){
        console.log(`Hello, my name is ${this.uname}`)
    }
}
 const u1 = new User ("Pranavi","pranavixo@gmail.com")
u1.greet();
 const u2 = new User ("Sonu","s2df@outlook.com");
 u2.greet();