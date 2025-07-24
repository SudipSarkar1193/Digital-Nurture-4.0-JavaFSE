import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort, index }) {
  return (
    <div className={styles.box} key={index}>
      <h3
        className={
          cohort.currentStatus === "Ongoing"
            ? styles["ongoing"]
            : styles["other-status"]
        }
      >
        {cohort.cohortCode}
      </h3>
      <dl>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        <dt>Current Status</dt>
        <dd>{cohort.currentStatus}</dd>
        <dt>Coach</dt>
        <dd>{cohort.coachName}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainerName}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
