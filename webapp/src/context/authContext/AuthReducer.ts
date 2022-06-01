import {LOGIN} from "../types"

export default (state, action) => {
    const {payload, type} = action;

    switch(type){
        case LOGIN: 
            localStorage.clear()
            localStorage.setItem("email", payload.user.email);
            localStorage.setItem("token", payload.token);
            localStorage.setItem("logued", "true");
            return {
                ...state,
                email: payload.user.email,
                token: payload.token,
                isAuthenticated: true,
                idRol: payload.user.idrol
            }
        default:
            return state;
    }
}