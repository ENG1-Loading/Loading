import {VerticalTimeline, VerticalTimelineElement} from 'react-vertical-timeline-component';
import 'react-vertical-timeline-component/style.min.css';
import '../static/weekly.css'
import React from 'react';
import Logo from "../Logo";
import {Notes} from '../content/Notes';
import Header from "../SharedComponents/Header";
const WeeklyNotes = () => {
    return (
        <div className={'weekly-container'}>
            <Header title={'Weekly Notes'} buttonName={'Download PDF'} file={'weekly.pdf'} />
            <VerticalTimeline
            >
                {/*    weekly notes*/}
                {Notes().map((note, index) => {
                    return (
                        <VerticalTimelineElement
                            className="vertical-timeline-element--work"
                            contentStyle={{background: 'rgb(255,255,255)', color: '#101010'}}
                            contentArrowStyle={{borderRight: '7px solid  rgb(33, 150, 243)'}}
                            date={note.date}
                            // iconStyle={{background: 'rgb(255,255,255)', color: '#0e0e0e'}}
                            iconStyle={{ background: 'rgb(33, 150, 243)', color: '#fff' }}
                            icon={<Logo height={'60px'} width={'60px'}/>}
                        >
                            <h3 className="vertical-timeline-element-title">{note.title}</h3>
                            <p className={'weekly-note'}>
                                {note.content}
                            </p>
                            {/*    gantt chart image*/}
                            <img src={note.image
                            } alt={`image for ${note.title}`} className={'gantt-chart'}/>
                        </VerticalTimelineElement>
                    )

                })
                }
            </VerticalTimeline>


        </div>
    );
};

export default WeeklyNotes;