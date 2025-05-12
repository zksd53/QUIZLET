"use strict";

const questionsArray = [];
const answersArray = [];

document.querySelector('.question-adder').addEventListener('click', function () {
    let totalQuestions = parseInt(prompt('How many questions do you want to add?'), 10);

    for (let i = 0; i < totalQuestions; i++) {
        let question = prompt(`Enter question ${i + 1}:`);
        let answer = prompt(`Enter answer for question ${i + 1}:`);

        questionsArray.push(question);
        answersArray.push(answer);
    }

    alert("All questions added successfully!");
});

document.querySelector('.Tester').addEventListener('click', function () {
    if (questionsArray.length === 0) {
        alert("No questions available. Please add them first.");
        return;
    }

    const indices = [...Array(questionsArray.length).keys()];

    for (let i = indices.length - 1; i > 0; i--) {
        let j = Math.floor(Math.random() * (i + 1));
        [indices[i], indices[j]] = [indices[j], indices[i]]; // Swap
    }

    for (let i = 0; i < indices.length; i++) {
        let idx = indices[i];
        let userAnswer = prompt(`Q${i + 1}: ${questionsArray[idx]}`);

        if (userAnswer === answersArray[idx]) {
            alert("Correct!");
        } else {
            alert(`Incorrect. Correct answer was: ${answersArray[idx]}`);
        }
    }

    alert("Quiz finished!");
});
