var buttons = document.querySelectorAll('.drum');
for (let i = 0; i < buttons.length; i++) {
    let button = buttons[i];
    button.addEventListener("mousedown",function(){
        playSound(this.innerHTML);
    });
}
document.addEventListener("keydown",function(e){
    playSound(e.key);
});

function playSound(key){
  var audio;
  switch(key){
      case "w":
        audio = new Audio("sounds/crash.mp3");
        break;
      case "a":
        audio = new Audio("sounds/kick-bass.mp3");
        break;
      case "s":
        audio = new Audio("sounds/snare.mp3");
        break;
      case "d":
        audio = new Audio("sounds/tom-1.mp3");
        break;
      case "j":
        audio = new Audio("sounds/tom-2.mp3");
        break;
      case "k":
        audio = new Audio("sounds/tom-3.mp3");
        break;
      case "l":
        audio = new Audio("sounds/tom-4.mp3");
        break;
      default:
        return;
  }
  audio.play();
  document.querySelector("."+key).classList.add("pressed");
  setTimeout(function(){document.querySelector("."+key).classList.remove("pressed");},100);
}
