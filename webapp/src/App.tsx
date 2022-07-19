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

const App = () => {
  return (
    <Router>
      <AuthState>
      <CryptoCurrencyState>        
      <div className="headerComponent">
      <HeaderComponent/>
      </div>
      <Routes>
        <Route path="/" element={<HomePage/>}/>
        <Route path="/crypto" element={<CurrenciesPage/>}/>
        <Route path="/favorite" element={<FavoritesPage/>}/>
        <Route path="/verification/*" element={<VerificationPage/>}/>
        <Route path="*" element={<NotFoundPage/>}/>
      </Routes>
      </CryptoCurrencyState>
      </AuthState>
    </Router>
  );
}

export default App;