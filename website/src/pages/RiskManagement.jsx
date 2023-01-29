import DataTable from 'react-data-table-component';
import {risks} from "../content/risks";

const columns = [
    {
        name: 'ID',
        selector: 'ID',
        sortable: true,
        width:'80px'
    },
    {
        name: 'Type',
        selector: 'Type',
        sortable: true,
    },
    {
        name: 'Description',
        selector: 'Description',
        sortable: true,
        wrap: true,
        minWidth:'300px'
    },
    {
        name: 'Likelihood',
        selector: 'Likelihood',
        sortable: true,

    },
    {
        name: 'Severity',
        selector: 'Severity',
        sortable: true,
    },
    {
        name: 'Mitigation',
        selector: 'Mitigation',
        sortable: true,
        wrap: true,
    },
    {
        name: 'Owner',
        selector: 'Owner',
        sortable: true,
        wrap: true
    },
];


function Table() {
    return (
        <div style={{maxWidth:"70%"}}>
        <DataTable
            columns={columns}
            data={risks}
            theme={'dark'}
        />
        </div>
    );
};
export default Table;