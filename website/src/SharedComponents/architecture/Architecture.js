import React from 'react';
import '../../static/architecture.css'
import ActivityDiagram from './activityDiagram.png'
import ClassDiagram from './classDiagram.png'
import ComponentDiagram from './componentDiagram.png'
import SequenceDiagram from './sequenceDiagram.png'
import StateDiagramChef from './stateDiagram_chef.png'
import StateDiagramCustomer from './stateDiagram_Customer.png'
import ComponentV1 from './Component-V1.png'
import ComponentV2 from './Component-V2.png'
import Header from "../Header";

const Architecture = () => {
    return (
        <>
            <Header title={'Architecture'} buttonName={'Download PDF'} file={'/architecture.pdf'}/>
            <div className="">
                <div className="diagrams">
                    <h3>Interim Versions </h3>
                    <h4> Component Diagram (V1)</h4>
                    <img src={ComponentV1} alt="Component Diagram (V1)" className="img-fluid"/>
                    <h4> Component Diagram (V2)</h4>
                    <img src={ComponentV2} alt="Component Diagram (V2)" className="img-fluid"/>
                    <h3>Structural Diagrams</h3>
                    <h4> Class Diagram</h4>
                    <img src={ClassDiagram} alt="Class Diagram" className="img-fluid class-diagram"/>
                    <h4> Component Diagram</h4>
                    <img src={ComponentDiagram} alt="Component Diagram" className="img-fluid"/>
                    <h3>Behavioural Diagrams</h3>
                    <h4> Activity Diagram</h4>
                    <img src={ActivityDiagram} alt="Activity Diagram" className="img-fluid"/>
                    <h4> Sequence Diagram</h4>
                    <img src={SequenceDiagram} alt="Sequence Diagram" className="img-fluid"/>
                    <div className="image-row">
                        <div className="image-column">
                            <h4> State Diagram (Chef)</h4>
                            <img src={StateDiagramChef} alt="State Diagram (Chef)" className="img-fluid"/>
                        </div>
                        <div className="image-column">
                            <h4> State Diagram (Customer)</h4>
                            <img src={StateDiagramCustomer} alt="State Diagram (Customer)" className="img-fluid"/>
                        </div>
                    </div>
                </div>
            </div>
        </>

    )
        ;
};

export default Architecture;
