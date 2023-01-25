import {VerticalTimeline, VerticalTimelineElement} from 'react-vertical-timeline-component';
import 'react-vertical-timeline-component/style.min.css';
import '../static/weekly.css'
import React from 'react';
import Logo from "../Logo";
import {Notes} from '../content/Notes';
const WeeklyNotes = () => {
    return (
        <div className={'weekly-container'}>
            <h1>Weekly Notes</h1>
            <VerticalTimeline layout="1-column-left"
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
                            icon={<Logo height={'40px'} width={'40px'}/>}
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