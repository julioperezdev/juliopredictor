import React from "react";
import { HeaderComponent } from "./components/common/header/HeaderComponent";
import {HomePage} from "./pages/publics/home/HomePage";
import './App.css';

const App = () => {
  return (
    <>
    <div className="headerComponent">
    <HeaderComponent/>
    </div>
    <HomePage/>
    </>
  );
}

export default App;