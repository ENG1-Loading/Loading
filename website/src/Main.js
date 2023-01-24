import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
import RiskAssesment from "./pages/RiskManagement";
import VersionControl from "./pages/VersionControl";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/notes" element={<App />}></Route>
            <Route exact path="/" element={<Homepage />}></Route>
            <Route exact path="/risk_assessment" element={<RiskAssesment />}> </Route>
            <Route exact path="/version_control" element={<VersionControl />}></Route>
        </Routes>   
    )
}
export default Main;