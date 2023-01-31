import React from 'react';
import '../../static/architecture.css'
import ActivityDiagram from './activityDiagram.png'
import activityDiagram from './activityFinal.txt'
import ClassDiagram from './classDiagram.png'
import classDiagram from './classDiagram.txt'
import ComponentDiagram from './componentDiagram.png'
import componentDiagram from './componentDiagram.txt'
import SequenceDiagram from './sequenceDiagram.png'
import sequenceDiagram from './sequenceFinal.txt'
import StateDiagramChef from './stateDiagram_chef.png'
import stateDiagramChef from './stateOneChef.txt'
import StateDiagramCustomer from './stateDiagram_Customer.png'
import stateDiagramCustomer from './stateTwoCustomer.txt'
import ComponentV1 from './Component-V1.png'
import ComponentV2 from './Component-V2.png'
import Header from "../Header";
import Image from "./Image";

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
                    <Image alt={"Class Diagram"} image={ClassDiagram} txt={classDiagram} className={'img-fluid class-diagram'} fileName={'classDiagram.txt'} />
                    <h4> Component Diagram</h4>
                    {/*<img src={ComponentDiagram} alt="Component Diagram" className="img-fluid" />*/}
                    <Image alt={"Component Diagram"} image={ComponentDiagram} txt={componentDiagram} className={'img-fluid component-diagram'} fileName={'componentDiagram.txt'}/>
                    <h3>Behavioural Diagrams</h3>
                    <h4> Activity Diagram</h4>
                    {/*<img src={ActivityDiagram} alt="Activity Diagram" className="img-fluid"/>*/}
                    <Image alt={"Activity Diagram"} image={ActivityDiagram} txt={activityDiagram} className={'img-fluid activity-diagram'} fileName={'activityDiagram.txt'}/>
                    <h4> Sequence Diagram</h4>
                    {/*<img src={SequenceDiagram} alt="Sequence Diagram" className="img-fluid"/>*/}
                    <Image alt={"Sequence Diagram"} image={SequenceDiagram} txt={sequenceDiagram} className={'img-fluid sequence-diagram'} fileName={'sequenceDiagram.txt'}/>
                    <div className="image-row">
                        <div className="image-column">
                            <h4> State Diagram (Chef)</h4>
                            {/*<img src={StateDiagramChef} alt="State Diagram (Chef)" className="img-fluid"/>*/}
                            <Image alt={"State Diagram (Chef)"} image={StateDiagramChef} txt={stateDiagramChef} className={'img-fluid state-diagram'} fileName={'stateDiagram_chef.txt'}/>

                        </div>
                        <div className="image-column">
                            <h4> State Diagram (Customer)</h4>
                            {/*<img src={StateDiagramCustomer} alt="State Diagram (Customer)" className="img-fluid"/>*/}
                            <Image alt={"State Diagram (Customer)"} image={StateDiagramCustomer} txt={stateDiagramCustomer} className={'img-fluid state-diagram'} fileName={'stateDiagram_customer.txt'}/>
                        </div>
                    </div>
                </div>
            </div>
        </>

    )
        ;
};

export default Architecture;
