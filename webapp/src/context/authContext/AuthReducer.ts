import { AuthenticationResponse } from "../../models/AuthenticationResponse";
import { UserReducedResponse } from "../../models/UserReducedResponse";
import {LOGIN, SIGNUP, UNVALIDATED, AUTHORIZING} from "../types"
import moment from "moment"

export default (state, action) => {
    const {payload, type} = action;

    switch(type){
        case AUTHORIZING:
            localStorage.clear()
            localStorage.setItem("email", payload.userVerified.username);
            localStorage.setItem("isAuthenticated", "true");
            return {
                ...state,
                isAuthenticated: true,
                email: payload.userVerified.username,
            }
        case SIGNUP:
            let payloadSignup : string = payload;
            localStorage.clear()
            localStorage.setItem("email", payloadSignup);
            localStorage.setItem("isAuthenticated", "false");
            console.log("email   -> ", localStorage.getItem("email"))
            console.log("isAuthenticated   -> ", localStorage.getItem("isAuthenticated"))
            return {
                ...state,
                email: payloadSignup,
                token: null,
                isAuthenticated: false,
                date: moment().format('LTS')
            }
        case LOGIN: 
            let payloadLogin : AuthenticationResponse = payload;
            localStorage.clear()
            localStorage.setItem("email", payloadLogin.username);
            localStorage.setItem("token", payloadLogin.authenticationToken);
            localStorage.setItem("isAuthenticated", "true");
            return {
                ...state,
                email: payloadLogin.username,
                token: payloadLogin.authenticationToken,
                isAuthenticated: true,
                date: moment().format('LTS')
            }
        case UNVALIDATED:
            let payloadUnvalidated : UserReducedResponse = payload;
            localStorage.clear()
            localStorage.setItem("email", payloadUnvalidated.email);
            localStorage.setItem("isAuthenticated", "false");
            return {
                ...state,
                email: payloadUnvalidated.email,
                token: null,
                isAuthenticated: false,
                date: moment().format('LTS')
            }
        default:
            return state;
    }
}