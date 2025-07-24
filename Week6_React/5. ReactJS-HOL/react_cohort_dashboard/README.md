# 📘 Cohort Dashboard - React Styling Assignment

## 🎯 Objectives

This project demonstrates how to:

- Understand the need for styling React components
- Apply styles using **CSS Modules** and **inline styles**
- Use `className` and `style` props effectively in React

---

## 🛠️ Skills You’ll Practice

- Styling React components
- Working with CSS Modules (`.module.css`)
- Inline styling using the `style` prop
- Applying dynamic styling based on component props

---

## 📁 Project Description

My team at Cognizant wants to build a **dashboard** to display the details of **ongoing and completed cohorts**. A basic React application is already scaffolded. My task is to **style** the React components.

---

## 🖌️ Styling Method

### 📦 Using CSS Modules

All component styles are defined in **`.module.css`** files like:

```js
import styles from "./CohortDetails.module.css";
```

### 🎨 Using Inline Styles

Some components may use inline styles based on props:

```js
<h3
  className={
    cohort.currentStatus === "Ongoing"
      ? styles["ongoing"]
      : styles["other-status"]
  }
>
  {cohort.cohortCode}
</h3>
```

## 🖥️ Output

![output](https://github.com/SudipSarkar1193/Digital-Nurture-4.0-JavaFSE/blob/main/Week6_React/5.%20ReactJS-HOL/react_cohort_dashboard/Output_Screenshot/OUTPUT.png?raw=true)
