Created a react project using :

```bash

npm create-react-app score_calculator_app

```

## Codes 

### CalulateScore.js

```js

import '../Stylesheets/mystyle.css'

const percentToDecimal = (decimal) => {
    return (decimal.toFixed(2) + '%')
}

const calcScore = (total, goal) => {
    return percentToDecimal(total / goal)
}
export const CalculateScore = ({ Name, School, total, goal }) => (
  <div className="formatstyle">
    <h1><font color="Brown">Student Details:</font></h1>
    
    <div className="Name">
      <b><span> Name: </span></b>
      <span>{Name}</span>
    </div>
    
    <div className="School">
      <b><span> School: </span></b>
      <span>{School}</span>
    </div>
    
    <div className="Total">
      <b><span>Total:</span></b>
      <span>{total}</span>
      <span>Marks</span>
    </div>
    
    <div className="Score">
      <b>Score:</b>
      <span>
        {calcScore(
          total,
          goal
        )}
      </span>
    </div>
  </div>
)

```

### mystyle.css

```css
.Name
{
    font-weight:300;
    color:blue;
}
.School
{
    color:crimson;
}
.Total
{
    color:darkmagenta;
}
.formatstyle
{
    text-align:center;
    font-size:large;
}

.Score
{
    color:forestgreen;
}

```

### App.js

```js

import { CalculateScore } from '../src/Components/CalculateScore';

function App() 
{
  return(
    <div>
      <CalculateScore Name={"Steeve"}
        School={"DNV Public School"}
        total={284}
        goal={3}
      />
    </div>
  )
}

export default App;


```

## Output :

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week6_React/3.%20ReactJS-HOL/score_calculator_app/Output_Screenshot/OUTPUT.png?raw=true)