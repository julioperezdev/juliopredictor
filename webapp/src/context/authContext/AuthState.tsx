import React,{useReducer, createContext} from "react";
import { LoginRequestDto } from "../../models/LoginRequestDto";
import AuthContext from "./AuthContext";
import AuthReducer from "./AuthReducer";
import HttpClient from "../../common/HttpClient";
import { AuthContextInterface } from "../../models/AuthContextInterface";

const AuthState = (props) =>{

    const initialState : AuthContextInterface = {
        email: null,
        token: null,
        isAuthenticated: false
    }

    const [state, dispatch] = useReducer(AuthReducer, initialState);

    const signupUser = async (signupRequest: LoginRequestDto) =>{
        const response = await HttpClient.post(`/signup/user`, signupRequest);
        console.log(response.data);
        dispatch({
            type: 'LOGIN',
            payload: response.data
        })
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
        }}>
        {props.children}
        </AuthContext.Provider>
        
    )
}

export default AuthState;