import DataTable, {createTheme} from 'react-data-table-component';
import {risks} from "../content/risks";
import Header from "../SharedComponents/Header";

createTheme('solarized', {
    text: {
        primary: 'rgb(206, 183, 183)',
        secondary: '#2aa198',
    },
    background: {
        default: 'rgba(52,52,52,0.05)',
    },
    context: {
        background: '#cb4b16',
        text: '#FFFFFF',
    },
    divider: {
        default: '#073642',
    },
    action: {
        button: 'rgba(0,0,0,.54)',
        hover: 'rgba(0,0,0,.08)',
        disabled: 'rgba(0,0,0,.12)',
    },
}, 'dark');
const columns = [
    {
        name: 'ID',
        selector: 'ID',
        width: '80px'
    },
    {
        name: 'Type',
        selector: 'Type',
    },
    {
        name: 'Description',
        selector: 'Description',
        cell: row => <span style={{textAlign: 'left'}}>{row.Description}</span>
    },
    {
        name: 'Likelihood',
        selector: 'Likelihood',
        width: '120px',
        conditionalCellStyles: [
            {
                when: row => row.Likelihood === 'H',
                style: {
                    backgroundColor: '#ff0000',
                    color: 'white',
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                }
            },
            {
                when: row => row.Likelihood === 'M',
                style: {
                    backgroundColor: '#ff9900',
                    color: 'white',
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                }
            },{
                when: row => row.Likelihood === 'L',
                style: {
                    backgroundColor: '#00ff00',
                    color: 'white',
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                }
            }
            ]

    },
    {
        name: 'Severity',
        selector: 'Severity',
        width: '100px',
        conditionalCellStyles: [
            {
                when: row => row.Severity === 'H',
                style: {
                    backgroundColor: '#ff0000',
                    color: 'white',
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                //     border only on right and left
                    borderRight: '1px solid #000000',
                    borderLeft: '1px solid #000000',
                }
            },
            {
                when: row => row.Severity === 'M',
                style: {
                    backgroundColor: '#ff9900',
                    color: 'white',
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                    borderRight: '1px solid #000000',
                    borderLeft: '1px solid #000000',
                }
            },{
                when: row => row.Severity === 'L',
                style: {
                    backgroundColor: '#00ff00',
                    color: '#ffffff',
                    // bold
                    fontWeight: 'bolder',
                    fontSize: '1.2em',
                    borderRight: '1px solid #000000',
                    borderLeft: '1px solid #000000',
                }
            }
        ]
    },
    {
        name: 'Mitigation',
        selector: 'Mitigation',
        cell: row => <span style={{textAlign: 'left'}}>{row.Mitigation}</span>

    },
    {
        name: 'Owner',
        selector: 'Owner',
        cell: row => <span style={{textAlign: 'left'}}>{row.Owner}</span>

    },
];

function Table() {
    return (
        <>
            <Header buttonName={'Download PDF'} file={'PDF'} title={'Risk Register'}/>
            <div style={{maxWidth: "70%", margin: 'auto', marginTop: "60px"}}>
                <DataTable
                    columns={columns}
                    data={risks}
                    theme={'solarized'}
                    customStyles={{
                        cells: {
                            style: {
                                paddingTop: '16px',
                                paddingBottom: '16px',
                                wordBreak: 'break-word',
                            },
                            draggingStyle: {},
                        },
                    }
                    }
                />
            </div>
        </>
    );
};
export default Table;