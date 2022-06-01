import {createContext} from "react";
import { AuthContextInterface } from "../../models/AuthContextInterface";

const AuthContext = createContext< AuthContextInterface | null >(null);

export default AuthContext;