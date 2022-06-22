export interface AuthContextInterface {
    email: string,
    token: string,
    isAuthenticated: boolean,
    signupUser ?: any,
    loginUser ?: any,
    decideAuth ?: any,
}