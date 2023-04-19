import {useRef, useState} from "react";
import NaverInput from "../../component/InputComponent";

export default function Main() {
  const formRef = useRef<HTMLFormElement | null>(null);

  const [id, setId] = useState<string>("");
  const [password, setPassword] = useState<string>('');
  const [isIdCheck, setIdCheck] = useState<boolean>(false);

  const onSubmitHandler = () => {
    if (!id.trim()) {
      setIdCheck(true);
      return;
    }
    setIdCheck(false);

    if (formRef) formRef.current?.submit();
  };

  return (
    <div className="main">
      <div className="content">
        <div className="sign-in-wrapper">
          <form
            ref={formRef}
            id="form"
            action="https://nid.naver.com/nidlogin.login"
            method="POST"
          >
            <ul className="panel-wrapper">
              <li className="panel-item">
                <div className="panel-inner">
                  <div className="id-password-wrapper">

                    <NaverInput label="아이디" type="text" name="id" maxLength={41} iconClass="icon-id" setter={setId} />
                    <NaverInput label="비밀번호" type="password" name="pw" maxLength={16} iconClass="icon-pw" setter={setPassword} />

                  </div>
                  <div className="sign-in-keep-wrapper">
                    <div className="keep-check">
                      <input
                        type="checkbox"
                        className="input-keep"
                        value="off"
                      />
                      <label className="keep-text">로그인 상태 유지</label>
                    </div>
                    <div className="ip-check"></div>
                  </div>

                  {isIdCheck && (
                    <div id="sign-in-error" className="sign-in-error">
                      <div className="error-message">
                        <strong>아이디</strong>를 입력하세요.
                      </div>
                    </div>
                  )}

                  <div className="sigin-in-button-wrapper">
                    <button
                      type="button"
                      className="sign-in-button"
                      onClick={() => onSubmitHandler()}
                    >
                      <span className="button-text">로그인</span>
                    </button>
                  </div>
                </div>
              </li>
            </ul>
          </form>
        </div>
        <ul className="find-wrapper">
          <li>
            <a
              className="find-text"
              href="https://nid.naver.com/user2/api/route?m=routePwInquiry&lang=ko_KR"
            >
              비밀번호 찾기
            </a>
          </li>
          <li>
            <a
              className="find-text"
              href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&lang=ko_KR"
            >
              아이디 찾기
            </a>
          </li>
          <li>
            <a
              className="find-text"
              href="https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR"
            >
              회원가입
            </a>
          </li>
        </ul>
        <div className="banner-wrapper">
          <div className="banner-content">
            <img
              className="banner-img"
              src="https://ssl.pstatic.net/melona/libs/1378/1378592/b3b27f5a48c19f04e111_20230331172904409.jpg"
            />
          </div>
        </div>
      </div>
    </div>
  );
}