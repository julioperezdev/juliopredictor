import axios from "axios";

const HttpClient = axios.create({
    baseURL : "http://localhost:8080/api",
    timeout : 100000,
    headers : {
        "Content-Type":"application/json"
    }
});

HttpClient.interceptors.request.use((config) =>{
    const token : string = localStorage.getItem("token")
        const header = token === null ? "" : "Bearer " + token;
        config.headers.Authorization = header;
        return config;
    },function(error){
        console.log("ERROR -> interceptor request");
        console.log(error);
        return Promise.reject(error)
    }
);

export default HttpClient;
