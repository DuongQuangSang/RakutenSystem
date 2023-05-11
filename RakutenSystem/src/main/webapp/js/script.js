'use strict';

function douiFunc() {
  const email = document.getElementById('email').value.toLocaleLowerCase();
  const emailerror = document.querySelector('.emailerror');
  const emailerrormes = document.querySelector('.emailerrormes');

  const emailkakunin = document.getElementById('emailkakunin').value.toLocaleLowerCase();
  const emailkakuninerror = document.querySelector('.emailkakuninerror');
  const emailkakuninerrormes = document.querySelector('.emailkakuninerrormes');

  const regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  const result = email.match(regex);
  console.log('check', result);

  // Email
  if(!email) {
    emailerror.style.display = 'inline-block';
    emailerrormes.style.display = 'inline-block';
    emailerrormes.textContent = 'メールアドレスを入力して下さい。';
    emailkakuninerror.style.display = 'inline-block';
    emailkakuninerrormes.style.display = 'inline-block';
    emailkakuninerrormes.textContent = 'メールアドレス（確認入力）を入力して下さい。';
    return;
  }
  if(!result||result==null) {
    emailerror.style.display = 'inline-block';
    emailerrormes.style.display = 'inline-block';
    emailerrormes.textContent = '入力されたメールアドレスの形式はご登録いただけません。';
    return;
  }

  // Email confirm
  if(email!==emailkakunin) {
    emailkakuninerror.style.display = 'inline-block';
    emailkakuninerrormes.style.display = 'inline-block';
    emailkakuninerrormes.textContent = 'メールアドレス（確認入力）とメールアドレスが一致しません。';
    return;
  } else if (!emailkakunin) {
    emailkakuninerror.style.display = 'inline-block';
    emailkakuninerrormes.style.display = 'inline-block';
    emailkakuninerrormes.textContent = 'メールアドレス（確認入力）を入力して下さい。';
    return;
  }
  

  // User Id
  const userId = document.getElementById('userId').value.toLocaleLowerCase();
  const userIderror = document.querySelector('.userIderror');
  const userIderrormes = document.querySelector('.userIderrormes');
  const regex1 = /^([a-zA-Z0-9]{6,})$/;
  const result1 = userId.match(regex1);

  
  const select = document.getElementById('igai');
  console.log(select.value);
  const check = document.getElementsByName('check');
  const len = check.length;
  let checkValue = '';

  for(let i = 0; i < len; i++) {
    if(check.item(i).checked) {
      checkValue = check.item(i).value;
    }
  }

  console.log(checkValue);
  if(checkValue==select.value) {
    if(!result1) {
      userIderror.style.display = 'inline-block';
      userIderrormes.style.display = 'inline-block';
      userIderrormes.textContent = '入力されたメールアドレスの形式はご登録いただけません。';
      return;
    }
  }

  // Password
  const passWord = document.getElementById('passWord').value.toLocaleLowerCase();
  const passWorderror = document.querySelector('.passWorderror');
  const passWorderrormes = document.querySelector('.passWorderrormes');
  const regex2 = /^([a-zA-Z0-9]{6,})$/;
  const result2 = passWord.match(regex2);

  if(!result2 || result2==passWord) {
    passWorderror.style.display = 'inline-block';
    passWorderrormes.style.display = 'inline-block';
    passWorderrormes.textContent = 'パスワードは6文字以上また半角英数字で入力してください。';
    return;
  } else if (result2==null) {
    passWorderror.style.display = 'inline-block';
    passWorderrormes.style.display = 'inline-block';
    passWorderrormes.textContent = 'パスワードを入力して下さい。';
    return;
  }


  // Sei
  const sei = document.getElementById('sei').value;
  const seierror = document.querySelector('.seierror');
  const seierrormes = document.querySelector('.seierrormes');

  // Mei
  const mei = document.getElementById('mei').value;
  const meierror = document.querySelector('.meierror');
  const meierrormes = document.querySelector('.meierrormes');

  if(!sei || !mei) {
    seierror.style.display = 'inline-block';
    seierrormes.style.display = 'inline-block';
    seierrormes.textContent = '姓（氏名）を入力してください。';
    meierror.style.display = 'inline-block';
    meierrormes.style.display = 'inline-block';
    meierrormes.textContent = '名（氏名）を入力してください。';
    return;
  } 


  // SeiKata
  const seiKata = document.getElementById('seiKata').value;
  const seiKataerror = document.querySelector('.seiKataerror');
  const seiKataerrormes = document.querySelector('.seiKataerrormes');

  // MeiKata
  const meiKata = document.getElementById('meiKata').value;
  const meiKataerror = document.querySelector('.meiKataerror');
  const meiKataerrormes = document.querySelector('.meiKataerrormes');

  const regex3 = /^[ァ-ンヴー]*$/;
  const result3Sei = seiKata.match(regex3);
  const result3Mei = meiKata.match(regex3);

  if(!seiKata || !meiKata) {
    seiKataerror.style.display = 'inline-block';
    seiKataerrormes.style.display = 'inline-block';
    seiKataerrormes.textContent = '姓（フリガナ）を入力してください。';
    meiKataerror.style.display = 'inline-block';
    meiKataerrormes.style.display = 'inline-block';
    meiKataerrormes.textContent = '名（フリガナ）を入力してください。';
    return;
  }

  if(!result3Sei) {
    seiKataerror.style.display = 'inline-block';
    seiKataerrormes.style.display = 'inline-block';
    seiKataerrormes.textContent = '姓（フリガナ）はカタカナで入力してください。';
  } 
  if(!result3Mei) {
    meiKataerror.style.display = 'inline-block';
    meiKataerrormes.style.display = 'inline-block';
    meiKataerrormes.textContent = '名（フリガナ）はカタカナで入力してください。';
  }

  window.location.href = "kakunin.html";
  
}


function kanryouFunc() {
  window.location.href = "kanryou.html";
}

