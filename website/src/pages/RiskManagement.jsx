import "../static/risk.css"
export default function RiskAssesment() {
    return ( 
        <>
        <h1>Risk assesment</h1>
            <table>
                <tr>
                <th>ID</th>
                <th>Type</th>
                <th>Description</th>
                <th>Likelihood</th>
                <th>Severity</th>
                <th>Mitigation</th>
                <th>Owner</th>
                </tr>
                <tr>
            <td>R1</td>
            <td>Time Difference</td>
            <td>Time zone differences could lead to absence of members during the meeting.</td>
            <td>M</td>
            <td>H</td>
            <td>Plan meeting more carefully to take into account time differences</td>
            <td>Ishrit </td>
            </tr>
            <tr>
            <td>R2</td>
            <td>Communication</td>
            <td>Relient on Discord, risk if Discord goes down.</td>
            <td>L</td>
            <td>M</td>
            <td>Use email instead</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R3</td>
            <td>Absence because any n reason</td>
            <td>Team members missing meetings.</td>
            <td>H</td>
            <td>M</td>
            <td>Posting a meeting summary to help members catch up from missed meeting</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R4</td>
            <td>Requirements delay</td>
            <td>Any kind of delay or error in the requirements</td>
            <td>L</td>
            <td>H</td>
            <td>Review requirements to mitigate errors.</td>
            <td>Joel, Ishrit, Joshua</td>
            </tr>
            <tr>
            <td>R5</td>
            <td>Merge conflicts</td>
            <td>When working on code if people don’t pull changes or the same file is changed by two separate people it could result in merge conflict</td>
            <td>M </td>
            <td>M</td>
            <td>Communicate what is being worked on, if merge conflicts happen resolve properly.</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R6</td>
            <td>Workload</td>
            <td>As we are all in our second year of uni we have high workloads and managing time between modules gets increasingly difficult, this could lead to some team members not pulling their weight and such</td>
            <td>M</td>
            <td>M-H</td>
            <td>Manage time effectively, and if you can’t do something due to other workloads communicate it to the team</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R7</td>
            <td>Game development experience</td>
            <td>The majority of our team has never had any experience with game development nor LibGDX so it is a big learning curve for some</td>
            <td>H</td>
            <td>M</td>
            <td>Spend more time learning libgdx, or carry the weight in other areas such as documentation</td>
            <td>Charlie, Josh, Joel, Ishrit, Hari</td>
            </tr>
            <tr>
            <td>R8</td>
            <td>Burnout </td>
            <td>With an overbearing workload and a game being quite long and at times tedious to make it will be very easy to become burned out </td>
            <td>H</td>
            <td>M</td>
            <td>Take breaks when needed and distribute workload fairly</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R9</td>
            <td>Schedules not lining up</td>
            <td>Due to team members having a differing in commitments it may be difficult to arrange workloads to be done by certain times and meetings at convenient times for all members</td>
            <td>L</td>
            <td>L</td>
            <td>Communicate when you will be able to do things and when you know you wont have something done by X time just say so</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R10</td>
            <td>Difference in writing code</td>
            <td>Members may have a preferred way to structure code, use code, and personal requirements for what they will accept as good code. Eg. one may focus on efficiency and one may focus on shortest code base etc.</td>
            <td>H</td>
            <td>L</td>
            <td>As long as code is well documented it is not a big deal as each function should be intuitive by design. As for acceptance of good code these should be laid out prior to the implementation being commenced</td>
            <td>Everyone</td>
            </tr>
            <tr>
            <td>R11</td>
            <td>Code redundancy</td>
            <td>Multiple people could write the same function separately without realising</td>
            <td>M</td>
            <td>L</td>
            <td>Simply check which functions are being used and which aren't. Remove the redundant ones</td>
            <td>Everyone</td>
            </tr>



            </table>
        </>
    )
}