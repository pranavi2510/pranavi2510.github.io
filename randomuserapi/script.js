const url = "https://randomuser.me/api";

const getUser = async() =>{
    const res = await fetch(url);
    const data = await res.json();
    console.log(data.results[0]);
    const user = data.results[0];


   
}
getUser()