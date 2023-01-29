import React from "react";
import { Routes ,Route } from 'react-router-dom';
import App from "./pages/WeeklyNotes";
import Homepage from "./pages/Homepage";
import RiskAssessment from "./pages/RiskManagement";
import VersionControl from "./pages/VersionControl";
import NotFound from "./pages/NotFound";
const Main = () => {
    return (
        <Routes>
            <Route exact path="/notes" element={<App />}></Route>
            <Route exact path="/" element={<Homepage />}></Route>
            <Route exact path="/risk_assessment" element={<RiskAssessment />}> </Route>
            <Route exact path="/version_control" element={<VersionControl />}></Route>
        {/*    404*/}
            <Route path="*" element={<NotFound />}></Route>
        </Routes>   
    )
}
export default Main;