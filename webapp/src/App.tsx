import { HeaderComponent } from "./components/common/header/HeaderComponent";

import {HomePage} from "./pages/publics/home/HomePage";
import {CurrenciesPage} from "./pages/publics/currencies/CurrenciesPage"
import {FavoritesPage} from "./pages/publics/favorites/FavoritesPage"
import {NotFoundPage} from "./pages/publics/notFound/NotFoundPage"

import AuthState from "./context/authContext/AuthState";

import './App.css';
import { BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import { VerificationPage } from "./pages/publics/verification/VerificationPage";
import CryptoCurrencyState from "./context/cryptoCurrencyContext/CryptoCurrencyState";
import { useContext, useState } from "react";
import AuthContext from "./context/authContext/AuthContext";

const App = () => {

  const UNAUTHENTICATED : number = 0;
  const AUTHENTICATION_IN_PROCESS : number = 1;
  const AUTHENTICATED : number = 2;

  const [authenticationStatus, setAuthenticationStatus] = useState(UNAUTHENTICATED);

  const {decideAuth} = useContext(AuthContext);

  const checkIfEmail = (email : string) : boolean => {
      const regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi;
      return regexExp.test(email);
  }

  const decideStatus = () => {
      const verifyEmailLocalStorage : boolean = checkIfEmail(localStorage.getItem("email"));
      const verifyIsAuthenticatedLocalStorage : boolean = localStorage.getItem("isAuthenticated") === "true";

      if(!verifyEmailLocalStorage){
          setAuthenticationStatus(UNAUTHENTICATED);
      }
      if(verifyEmailLocalStorage && !verifyIsAuthenticatedLocalStorage){
          setAuthenticationStatus(AUTHENTICATION_IN_PROCESS);
      }
      if(verifyEmailLocalStorage && verifyIsAuthenticatedLocalStorage){
          setAuthenticationStatus(AUTHENTICATED);
      }
  }

  return (
    <Router>
      {/* <AuthState>
      <CryptoCurrencyState>         */}
      <div className="headerComponent">
      <HeaderComponent/>
      </div>
      <Routes>
        <Route path="/" element={<HomePage authenticationStatus={authenticationStatus} decideAuth={decideAuth} decideStatus = {decideStatus}/>}/>
        <Route path="/crypto" element={<CurrenciesPage authenticationStatus={authenticationStatus}/>}/>
        <Route path="/favorite" element={<FavoritesPage/>}/>
        <Route path="/verification/*" element={<VerificationPage/>}/>
        <Route path="*" element={<NotFoundPage/>}/>
      </Routes>
      {/* </CryptoCurrencyState>
      </AuthState> */}
    </Router>
  );
}

export default App;