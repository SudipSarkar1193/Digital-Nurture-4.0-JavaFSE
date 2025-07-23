This is the second react application (student management portal) for Cognizant's DN 4.0 program 

Created the app with the command :

```bash
 npx create-react-app myfirstreact .
```

## Code :

### About.js 

```jsx
import React, { Component } from "react";
export class About extends Component{
    render(){
        return(
        <div>
            <h3>Welcome to the About page of the Student Management Portal</h3>
        </div>)
    }
}

```

### Contact.js 

```jsx
import React, { Component } from "react";
export class Contact extends Component{
    render(){
        return(
        <div>
            <h3>Welcome to the Contact page of the Student Management Portal</h3>
        </div>)
    }
}

```
### Home.js 

```jsx
import React, { Component } from "react";
export class About extends Component{
    render(){
        return(
        <div>
            <h3>Welcome to the Home page of the Student Management Portal</h3>
        </div>)
    }
}

```

### App.js 

```jsx
import './App.css';
import {Home} from './components/Home';
import {About} from './components/About';
import {Contact} from './components/Contact';

function App() {
  return (
    <div className="container">
      <Home/>
      <About/>
      <Contact/>
    </div>
  );
}

export default App;

```

### App.css 

```css

.container {
  padding: 20px;
  max-width: 1200px;
  margin: auto; 
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  gap: 20px;
}
body {
  font-family: Arial, sans-serif;
  font-style: italic;
  margin: 0;
}

```

## Output 

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week6_React/2.%20ReactJS-HOL/student_app/Output_Screenshot/OUTPUT.png?raw=true)
