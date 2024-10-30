//function to simulate network delay

const fetchData = ()=>{
    return new Promise((resolve,reject) =>{
        setTimeout(()=>{
            const success = Math.random() > 0.5;
            if(success){
                resolve('Data fetched Successfully');
            }else{
                reject('Failed to fetch Data');
            }
        }, 5000);
    });
}

//handling the promise when button is clicked

document.getElementById("loadData").addEventListener('click',()=>{
    document.getElementById("result").textContent= 'Loading.....';




fetchData()
.then(data=>{
    document.getElementById('result').textContent = data;
})
.catch(error=>{
    document.getElementById('result').textContent = error;
});
});


