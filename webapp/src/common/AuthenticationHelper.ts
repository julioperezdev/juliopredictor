const UNAUTHENTICATED : number = 0;
const AUTHENTICATION_IN_PROCESS : number = 1;
const AUTHENTICATED : number = 2;

export const isAuthenticated = (authenticationStatus: number): boolean =>{
    return localStorage.getItem('isAuthenticated') == 'true' || authenticationStatus == AUTHENTICATED;
}

export const isAuthenticationInProcess = (authenticationStatus: number): boolean =>{
    return authenticationStatus == AUTHENTICATION_IN_PROCESS;
}