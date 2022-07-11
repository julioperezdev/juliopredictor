export interface AuthContextInterface {
    email: string,
    token: string,
    isAuthenticated: boolean,
    date: string
    /*signupUser ?: any,*/
    loginUser ?: any,
    decideAuth ?: any,
    verifyToken ?: any,
}