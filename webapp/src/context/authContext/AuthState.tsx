import React,{useReducer, createContext} from "react";
import { LoginRequestDto } from "../../models/LoginRequestDto";
import AuthContext from "./AuthContext";
import AuthReducer from "./AuthReducer";
import HttpClient from "../../common/HttpClient";
import { AuthContextInterface } from "../../models/AuthContextInterface";
import { PredictorRestResponse } from "../../models/PredictorRestResponse";
import { AuthenticationResponse } from "../../models/AuthenticationResponse";
import { UserReducedResponse } from "../../models/UserReducedResponse";

const AuthState = (props) =>{

    const initialState : AuthContextInterface = {
        email: null,
        token: null,
        isAuthenticated: false
    }

    const [state, dispatch] = useReducer(AuthReducer, initialState);

    const signupUser = async (signupRequest: LoginRequestDto) =>{
        //await HttpClient.post(`/signup/user`, signupRequest)
        const response = await HttpClient.get(`/currencies/fiat`)
        //currencies/fiat
        .then((response): any =>{
            console.log(response.data);
        })
        .catch((error) =>{
            console.log(error)
        })
        /*
        dispatch({
            type: 'LOGIN',
            payload: response.data
        })*/
    }
    const decideAuth = async(decideRequest: LoginRequestDto) =>{
        try{
            console.log("antes de llamar  --->", decideRequest)
            //const response : PredictorRestResponse<any> = await HttpClient.post(`/decideAuth`, decideRequest);
            const responsePromise = await HttpClient.post(`/decideAuth`, decideRequest);
            const response : PredictorRestResponse<any> = responsePromise.data;
            console.log(response)
            if(response.statusCode === 200){
                //login
                console.log("entrooo 200")
                let result : PredictorRestResponse<AuthenticationResponse> = response;
                /*dispatch({
                    type: 'LOGIN',
                    payload: result.body
                })*/
                console.log(result.body.username)
                console.log(result.body.refreshToken)
                console.log(result.body.expireAt)
                console.log(result.body.authenticationToken)
            }
            if(response.statusCode === 201){
                //signup
                console.log("entrooo 201")
                let result : PredictorRestResponse<string> = response;
                /*dispatch({
                    type: 'SIGNUP',
                    payload: result.body
                })*/
                console.log(result.body)
            }
            if(response.statusCode === 206){
                //falta validar
                console.log("entrooo 206")
                let result : PredictorRestResponse<UserReducedResponse> = response;
                /*dispatch({
                    type: 'UNVALIDATED',
                    payload: result.body
                })*/
                console.log(result.body.email)
                console.log(result.body.enable)
            }
            
        }catch(error){
            if (typeof error !== "string") console.log(error);
            if (typeof error === "string") throw new Error(error);   
        }
        
    }

    const loginUser = async (loginRequest: LoginRequestDto) =>{
        const response = await HttpClient.post(`/auth/signin`, loginRequest);
        console.log(response.data);
    }

    return(
        <AuthContext.Provider value= {{
            email: state.email,
            token: state.token,
            isAuthenticated: state.isAuthenticated,
            signupUser,
            loginUser,
            decideAuth,
        }}>
        {props.children}
        </AuthContext.Provider>
        
    )
}

export default AuthState;