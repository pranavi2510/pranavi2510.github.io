import {add} from "./math.js";

document.getElementById('calculate').addEventListener('click',
    ()=>{
        const result=add(9,7);
        alert(`The result is ${result}`);
    }
)