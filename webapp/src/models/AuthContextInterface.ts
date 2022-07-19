export interface AuthContextInterface {
    email: string,
    token: string,
    isAuthenticated: boolean,
    date: string,
    refreshToken : string,
    expireAt : any,
    /*variables*/
    loginUser ?: any,
    decideAuth ?: any,
    verifyToken ?: any,
}