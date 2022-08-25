import { AuthenticationResponse } from "../../models/AuthenticationResponse";
import { UserReducedResponse } from "../../models/UserReducedResponse";
import {LOGIN, LOGOUT, SIGNUP, UNVALIDATED, AUTHORIZING} from "../types"
import moment from "moment"

export default (state, action) => {
    const {payload, type} = action;

    switch(type){
        case AUTHORIZING:
            localStorage.clear()
            console.log(payload)
            localStorage.setItem("email", payload.userVerified.email);
            localStorage.setItem("isAuthenticated", "true");
            return {
                ...state,
                isAuthenticated: true,
                email: payload.userVerified.email,
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
            console.log("HEEEEEEEEEE",payloadLogin)
            localStorage.clear()
            localStorage.setItem("email", payloadLogin.username);
            localStorage.setItem("token", payloadLogin.authenticationToken);
            localStorage.setItem("isAuthenticated", "true");
            localStorage.setItem("refreshToken", payloadLogin.refreshToken);
            localStorage.setItem("expireAt", payloadLogin.expireAt);
            return {
                ...state,
                email: payloadLogin.username,
                token: payloadLogin.authenticationToken,
                isAuthenticated: true,
                date: moment().format('LTS'),
                refreshToken : payloadLogin.refreshToken,
                expireAt : payloadLogin.expireAt,
            }
        case LOGOUT:
            localStorage.clear();
            return {
                ...state,
                email: null,
                token: null,
                isAuthenticated: false,
                date: moment().format('LTS'),
                refreshToken : null,
                expireAt : null,
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