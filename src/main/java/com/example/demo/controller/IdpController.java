package com.example.demo.controller;

import com.example.demo.dto.*;
import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/idp/.well-known/openid-configuration")
public class IdpController {

    JSONArray test = null;

    @GetMapping
    public ResponseEntity<OpenIdConfigDto> getOpenIdConfigDto() {

        OpenIdConfigDto openIdConfigDto = new OpenIdConfigDto(
                "https://mockregistry.com.au:8443/idp",
                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/jwks",
                "https://mockregistry.com.au:8443/idp/connect/token",
                Arrays.asList("sub"),
                Arrays.asList("PS256"),
                Arrays.asList("public"),
                Arrays.asList("cdr-register:bank:read"),
                Arrays.asList("token"),
                Arrays.asList("client_credentials"),
                Arrays.asList("private_key_jwt"),
                true,
                Arrays.asList("PS256")
        );

        return ResponseEntity.ok(openIdConfigDto);
    }

    @GetMapping("/jwks")
    public ResponseEntity<JwksDto> getJwks() {

        JwksDto jwksDto = new JwksDto(
                Arrays.asList(
                        new JwkDto (
                                "RSA",
                                "AQAB",
                                "sig",
                                "mockregisrtysigning",
                                "PS256",
                                "nSBPmUSdo94zlhRtqqH7C444m8boxzdRSOORlFjrBdoGtWQytD8K3siOaZnao6OOP-EBddK3A8iFlSQ_-fV0Hv7HyToRnUiEcwNvWm3oLQT0uxtC9M0n-L5-B4ywI4CK_4Mm1A5wfiHGrclUOLa6Xf5ImggCOFrY6-amb3g9bCtcZzm5xPPtz6s0hFZzhURW4Y2rbdIN6AHlDu05S5_DepxStYYYi1fX4pclg9wAqQYI5xiLgtVPywr4Fo2RDOY_-bbrJUV63O7CKqe0WL9_UjYeTZ2ULblEQYj8K4hmKrZRIXdC9lxKfVZG_pBUj_VscN9rpLn_kP8PJINMcFcUhw",
                                Arrays.asList("MIIFSDCCAzACCQDpEn+7E76JBTANBgkqhkiG9w0BAQsFADBmMQswCQYDVQQGEwJTTDERMA8GA1UECAwIU291dGhlcm4xDjAMBgNVBAcMBUdhbGxlMQ0wCwYDVQQKDARXU08yMQswCQYDVQQLDAJPQjEYMBYGA1UEAwwPbW9ja3JlZ2lzdHJ5LmxrMB4XDTIxMDIwNzA4MjA1NVoXDTIyMDIwNzA4MjA1NVowZjELMAkGA1UEBhMCU0wxETAPBgNVBAgMCFNvdXRoZXJuMQ4wDAYDVQQHDAVHYWxsZTENMAsGA1UECgwEV1NPMjELMAkGA1UECwwCT0IxGDAWBgNVBAMMD21vY2tyZWdpc3RyeS5sazCCAiIwDQYJKoZIhvcNAQEBBQADggIPADCCAgoCggIBALVxxr2YqVaQsPTeUMESkUx1glCjOOpy4MMsGePgBkcGsuMEFaUsxn+ATjd5aejccYOCBIwtbF8DxC3AL166JB979Ohr0jD9YrN7M/mmIML+ucP/uuyOx0fNNk5+buOdnBfXai06SxSLvpq6NCX7NPynj0Y/Ie3yRQd/CycQlPT2I1TWWLyZa07QC7CA8Bbg9LA3OJFapxSMLjjANzmbTWP73gBURNZmfOZbdOeUYo0DWUrD83R+o3uJTarwf3v48AcK3MIha5Rqbt6OF5wtcB7Bm+GpZFbHxgQfNV4e6Bsbjh4UCGSpS9JVBHG9DAkupzEOzqFIu2B5d3FU0lw5D28VnG2HeN9VJYuBA0xYlkHZuFi2aV8bytCnfOt2/QQEzNY4BUJoytZ1A+louuXogFrFhGJoNJTqVr2hkoIXZ4V2op7DF2QWYihR9NZcv/NpOUr6zUVTL0/UV1sOrsav9zsXdwMUPRHWGw59Mz2cxK6dngt7IUTJnJcqZR13pKRaRVZoCy2+5ONi78jDTZO4PdaQrjeFnAWmdJ5DYm60uehelPlRw2/+iODjSBup8gPxdTK3jvi4bhwB0cGQ74OD8NfjJIsxv0YNRPRJCQK/Ic1u3CjM+3t8wl9XtUupdDlPaFKGplnp7qcrj/yUHRWyQX7XUi36fllm23Hmn2E4Mlr3AgMBAAEwDQYJKoZIhvcNAQELBQADggIBAHXKs2x0ZFZ7urItLK6k0Q42OIT8b9qC4tG9ckekTt/HxFRhUqgTCGJUUL60Ke3FiK8XEG+BIx7beRtHqv1M933QM7qL3+dHUqFkQbL1e1G8B3/Km/cX/MPo7w/ngIPq+iX5wXUOKl27lhgI46BIWviD563/pX4oIrEubemJd48tHHVZNowpKv00CLEXtTCcBFFAm2lDbBYtE9XqEnwDviR96d4g7kcS/EwQmppVTM+2VbvhdWOD0+kxfskURHAPmMdiEEXsYC5wQMBhMeDshPondJ0cVn2a229KSYrF566CFLnu+4wkqFYuzgjNATo+xSJ+IpdB7wCrPYAKC6fAk1CcITyBxjnM09s3NXNTqdN6sQUANRi5lFhNKa9sDIwBpdnwrw2v0Gs1PxKNoauOKpQv9FKmvKZQKBYjSqy/AxO4nnP7Kd0zSe1Rc/W6kIkfDu/3aynvPxdBhP6OUGd7f1PIbMHG1V7s1lm2nezoj3E9/pEPyJr/5PGmx6iIO0lU1UKNqVfGK4/Jr8Q5VMhFqoYlM0pG/mEkskD0PmnNoRqulBgEvAcFTTQIMx8NGlsGNBsgkOV2t2z/fXmyjfnQq+MMsjTcfcXQ8s1spAUobFzGzfv4Xiws8tNxLgOSrsYzDZRlfZIIfjppU2XGaLrMF7BHL0472xIwwmcH7mHixJnk"),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/jwks"

                        )

                )
        );

        return ResponseEntity.ok(jwksDto);
    }

    @GetMapping("/adrjwks")
    public ResponseEntity<JwksDto> getadrJwks() {

        JwksDto jwksDto = new JwksDto(
                Arrays.asList(
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "enc",
                                "adr100sp100",
                                "PS256",
                                "gEW8miZgcblZZ1P0TqaG258e_YOiTrGwBi2DvxdDwSY0tmUeQx4S4j1Yg6lx0bViwEqYOem8xuADpNSTPQe-7xOythwCtiNrLEpMdc7DLrDpY3PHaaLfgqd5sqRNB_Bd8Pqzg3-w15zDQqtwkdwQeyeKTw8NFwP58yvYV9REBPy72pSJBKZrLwcon2xUN4xqFxfmBpRqnXwB3lJIqhsAxOTsvU5kKv8_iz26B-s-Au7cq-3QSJAw29V-zjMO0IcdEYeOGhBHHKdUMirOTv2Jbz3gIq-MpfAEoEiUgJyqKJYSO24v-cYGsv0Bb2uimPKMgjuQ15u5JbENtDClRabVmQ",
                                Arrays.asList("MIICqjCCAZKgAwIBAgIGAXiN0MA4MA0GCSqGSIb3DQEBCwUAMBYxFDASBgNVBAMMC2FkcjEwMHNwMTAwMB4XDTIxMDQwMTE0MjI1MVoXDTIyMDEyNjE0MjI1MVowFjEUMBIGA1UEAwwLYWRyMTAwc3AxMDAwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCARbyaJmBxuVlnU/ROpobbnx79g6JOsbAGLYO/F0PBJjS2ZR5DHhLiPViDqXHRtWLASpg56bzG4AOk1JM9B77vE7K2HAK2I2ssSkx1zsMusOljc8dpot+Cp3mypE0H8F3w+rODf7DXnMNCq3CR3BB7J4pPDw0XA/nzK9hX1EQE/LvalIkEpmsvByifbFQ3jGoXF+YGlGqdfAHeUkiqGwDE5Oy9TmQq/z+LPboH6z4C7tyr7dBIkDDb1X7OMw7Qhx0Rh44aEEccp1QyKs5O/YlvPeAir4yl8ASgSJSAnKoolhI7bi/5xgay/QFva6KY8oyCO5DXm7klsQ20MKVFptWZAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAFaeX8F6J3wa0ouXN3Ts26ok+PmZEuzonxC5D5aD0FVQgbqLwozeHichKU6B3fAje7F1kUi1mcefW9yY8iMXAHY39HGA9ANBznEkQeyLUG5uIF9RhZw1aaqlVO4vyHe16BUo4W1XCqb95mNY5szWKydYHX+lWdiJWQJ1hYsop9HbQPtRXPI5GcVY0KOCjujY8XN0q+sENfmLJ026NPfKh4yR167Er7oOYn1f4KaiKdTHCYtLS3/kMAh+Q+zENwGhZmSc53q67P7xeHlXPgDWyBSBfns4d6YE6+pbiWx9PuqmIFUYvTA1n1A3r+SFGoVyACzL0yIi1vJKOpRBtOQHg2g="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "enc",
                                "adr01sp02",
                                "PS256",
                                "7CuFQR8FdNxRhMCGSOrSzAWQex7PrJCYtEOPKX2cSS4qRWwgPpdo92OL-hZ_yCQbAeSuh2ml9Zv_3QAFnsBcEKBiB9YkZnUTTOIEi9CApU65rRB6JmD_nS76lxFHZhvNMzl51TvoDi3la8yALYKkri7lCQQCCR9SDVX8SRJijA_2OYqrB90BRHzr58w1otLLf2MJh8wGw42zXMF6znN1red4_njq_xvVstNWVwwn80AXqiQVyaA4XmpQJkafE7VWG9xcTEjI7H4PuON3QRSRm_Of_HwtDEGmJCNFOcYZNs0oqCcBLFDU0iK4oRM_AnsUJ6CPg--xKJyzP2XxDduBqw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXd7WCCvMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAxc3AwMjAeFw0yMTAyMDcwNzE1MDlaFw0yMTEyMDQwNzE1MDlaMBQxEjAQBgNVBAMMCWFkcjAxc3AwMjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAOwrhUEfBXTcUYTAhkjq0swFkHsez6yQmLRDjyl9nEkuKkVsID6XaPdji/oWf8gkGwHkrodppfWb/90ABZ7AXBCgYgfWJGZ1E0ziBIvQgKVOua0QeiZg/50u+pcRR2YbzTM5edU76A4t5WvMgC2CpK4u5QkEAgkfUg1V/EkSYowP9jmKqwfdAUR86+fMNaLSy39jCYfMBsONs1zBes5zda3neP546v8b1bLTVlcMJ/NAF6okFcmgOF5qUCZGnxO1VhvcXExIyOx+D7jjd0EUkZvzn/x8LQxBpiQjRTnGGTbNKKgnASxQ1NIiuKETPwJ7FCegj4PvsSicsz9l8Q3bgasCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEA6FuBihS71W8ftVeYqarRRqkFmU4/F8LI7mlqg89ElVB3Ff0tydktbsy8FsHmHNKl6EIibLTdmLj2l11V1AUmqrulnTX4q77+9ROY25UdKyfZX3fnRJUOzuMnoUlZLt2z3pxGyJRFGd3SyRvY9i6pR4Gw/FBkVcmOf10AuMJSizAaiPbgDXku9vPCIDFB9CZDkwF+Z4tZuhhinSC+QGHHPHu/9R4qaJNlhXGO/2E1AT54ZV+XonuOKd+/iljq30hIxM7s2xavkgzbFjvAmkpLaMec0WyzMo/Xci+avi4R+ATHo/I6684HGHjPHTydO3mFALBb+wec6H76XkZloOAVxQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr02sp03",
                                "PS256",
                                "hfN3XK-b-6I1_rB9ybnsLz8PKbif8SzuysJ2vD0Xp4Sf02OvlwhtcwvwepTWTvOV0rV6urHtnn_0JRdqtwN1Nm72vuulyFMvKrheyLmmPSKd0ofrV3eVvdybNQXSWJHOb4TvRl-jK2WyexN61CHmz3f8m5pPqopOSOVx4OAliPgmrpGQaPcnzITmFvQcV2aOR3PRJe8sKOV77jMU5qgAPrOeIlyY6gi8kJx7PabtbqVF8Z55UQqT9oeKQ1up7DwOiu42vFnMq1q5OSjZMKMclLj1Tkn0TRL04PZsfJcn4ISKYKcbgyNj8W8mMbaVOEitPi9ehTcITZOP-jKQfI1QOQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXd7cAxqMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAyc3AwMzAeFw0yMTAyMDcwNzQxMTZaFw0yMTEyMDQwNzQxMTZaMBQxEjAQBgNVBAMMCWFkcjAyc3AwMzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIXzd1yvm/uiNf6wfcm57C8/Dym4n/Es7srCdrw9F6eEn9Njr5cIbXML8HqU1k7zldK1erqx7Z5/9CUXarcDdTZu9r7rpchTLyq4Xsi5pj0indKH61d3lb3cmzUF0liRzm+E70ZfoytlsnsTetQh5s93/JuaT6qKTkjlceDgJYj4Jq6RkGj3J8yE5hb0HFdmjkdz0SXvLCjle+4zFOaoAD6zniJcmOoIvJCcez2m7W6lRfGeeVEKk/aHikNbqew8DoruNrxZzKtauTko2TCjHJS49U5J9E0S9OD2bHyXJ+CEimCnG4MjY/FvJjG2lThIrT4vXoU3CE2Tj/oykHyNUDkCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEARj9GwTFgF/3k7nZPvUE0v4lBYqc/bBh7felRBaagejxIZQxaybSZjj+9XYb/faY6L41X56uA1vgBLJ7llWBmrtrb4m6sn7aeGRR+AFVnHH6EjyoFUVjTDUJU7heMAm16e9AFO1PCYjxCO580Q08XYc7JwyHdU1ltsNkp3oBdzPZcAscTtKJC19eVqTrLMOsac1lvkV031TsCJMK6TigMRZ4SS6YJXlXplUqW8FKUCN9Lvoc7R9I4uR7KdxpsxcjQIZupDO0hvsoRZXjxFU69D7mUH2awLdhkttRwnFoIBG4uDJPcuV2/sqvzOFUaP+PiFaleaXKgUAPAF3UlnDxMog=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr01sp01",
                                "PS256",
                                "zqwL4N4ilwGQDeJyTLwy7b24Xw1tJ3l3VSvIFYaLzKUAgXlJrErSGiae2sdgUgmCxcj2UY4eaDGAEIBuzdlPx1p8Q7PgIjkOQbOdPFc5wRpataotZut2K8BPbv781Aps53qw3XRMyYFlXIW99yT9HfbWKGy0uzat96IZVSaD3BWCRDXfWOknMeZegu5twXc3GaHFwGMMKYWSTRahXRMtpT0e7jeC5xOxP8pkDwb5nRPfT2UhfDfFYOBGsMjZAPOOjuOTTE1R2yZsefT8ahY7PKKC1r-P01ZngK6oruhxoll-9GNnxJq7Zu7F8nWDqUm2y4ETgw84eZilL89OaWitkw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXd7BdgPMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAxc3AwMTAeFw0yMTAyMDcwNTQ1MTZaFw0yMTEyMDQwNTQ1MTZaMBQxEjAQBgNVBAMMCWFkcjAxc3AwMTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAM6sC+DeIpcBkA3icky8Mu29uF8NbSd5d1UryBWGi8ylAIF5SaxK0homntrHYFIJgsXI9lGOHmgxgBCAbs3ZT8dafEOz4CI5DkGznTxXOcEaWrWqLWbrdivAT27+/NQKbOd6sN10TMmBZVyFvfck/R321ihstLs2rfeiGVUmg9wVgkQ131jpJzHmXoLubcF3NxmhxcBjDCmFkk0WoV0TLaU9Hu43gucTsT/KZA8G+Z0T309lIXw3xWDgRrDI2QDzjo7jk0xNUdsmbHn0/GoWOzyigta/j9NWZ4CuqK7ocaJZfvRjZ8Sau2buxfJ1g6lJtsuBE4MPOHmYpS/PTmlorZMCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEApM1vSRBlhCG9giSreW+Ncxj/zSVOzLSOG3/sIsYYpxYkrT+r2s+Z2bQiGL9iKTPpuVbEF2iOK8Uzanc8E8gjfZdU9Skac+mpvu/Q/WsQCD5TjjRnBay1WiAIzw4aP6FO+//xe+u/FXapxA/saYjFplE+l51V7ohm+yV8zxkIunXT6FQ4hPmEsA5hGB0avLEAOI//kNy15A9xyrhYKK+WA3M10jPgLCBAq9DiYAvWgASrb4w4OvA2pJoHsdwvJ3eI5qGMOA7WD/23/ffBL/9CFHB+VW1Erhhsd+rNL13TZt+Q4sS+obw5W8uGfLNRTb8qB73lxlVGaWhFpiTGNQXUmQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr03sp05",
                                "PS256",
                                "hd1I9XNE3yfOdCl-bayIZn6rSU0vw2oazqRWkHEwadkuOQLjjpXjoDx-ZU1lm2nkOno-euLymmaEjxQHjb_4xW7ChsjkcojfjIiDbq1wO1Op5lW_5z1cm-19N9gh9b-F-IQiQL_zRtQl0wBd9MHXb2I05JtL7AKqzEWTI4YeIv0wuPJKrDR-m7_4D70o2EBF--VxErtg6jwoMxS50_ALf96hlkl-lw9bhfIJFZCbzes49viISkXLK2MgAEs4-h_C0fiCd2lss_Pzx7_o94KktYFCRhUovkMievG4NL3dFfR70JiQsBlCRqc_1dNQ97SN_Kdluyqi3gkl_neFG-buLQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXeu5MYhMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAzc3AwNTAeFw0yMTAyMTcwNzI5MjRaFw0yMTEyMTQwNzI5MjRaMBQxEjAQBgNVBAMMCWFkcjAzc3AwNTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIXdSPVzRN8nznQpfm2siGZ+q0lNL8NqGs6kVpBxMGnZLjkC446V46A8fmVNZZtp5Dp6Pnri8ppmhI8UB42/+MVuwobI5HKI34yIg26tcDtTqeZVv+c9XJvtfTfYIfW/hfiEIkC/80bUJdMAXfTB129iNOSbS+wCqsxFkyOGHiL9MLjySqw0fpu/+A+9KNhARfvlcRK7YOo8KDMUudPwC3/eoZZJfpcPW4XyCRWQm83rOPb4iEpFyytjIABLOPofwtH4gndpbLPz88e/6PeCpLWBQkYVKL5DInrxuDS93RX0e9CYkLAZQkanP9XTUPe0jfynZbsqot4JJf53hRvm7i0CAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAZ7a6Pn/zgjbCK2TrOxqq0GWVfcLJ7ho58wgYV9qXz2vjumpKHqVdWagXBizT+fj0up6GOmTdxs6I624ABa/TMEwEHK9/yG4woMGPtVHqnEkgIs7Kk2fLACGpJJdBKc41l8QhjqshGClhwdDn2/kV53aAoJQsbzQS1pbFIuDsvSMY86JyIVQwC5XuZ07nZW0rmf2fO2Qg3g/hEA2kQGOeBwzo1y2miwFXuWhOY0ZXfeS2d4pEGmneMKJ1ntghulFokhXUFlSLRW8MXdjgeJEaH363q1tML9YyhASG2oTcURJaSpFqPASBf9V4tKYOspmcm0Bjx3kaI1S70OSjUOwDow=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr04sp07",
                                "PS256",
                                "mSiUUUXwqVdm3VKK7eCcDnTzynav7plRUpEwMUXSiXHIjqsmrgtffFAYASNf6xWo0Qxyti4GKbeYjdS8aAUMcwFNAJNXzVoh8Eo20dnGUDjk-ujHJmxLRC5R9dFiUWdgNGP04F-Bl0wSVbMemIsjIu32Rc6bzZK4zH7Guxdn-uRlFtxjiwp82ZDgLOgYLk4L7dC3NtntvgBW3CFDmyvHAdz1jr2QjWoupT-wKZ1Lu3u9OSs9fxw19Do8BLYYSO7wYDHr1RvlW-n0m2nf25GiT18vegmzN0_H8Lbhs10292zVIy9LovZ9YpA4kLFlDYxgd4SvNJDC2pIeulzNaW9-aw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevj91BMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA0c3AwNzAeFw0yMTAyMTcxMDM2MTdaFw0yMTEyMTQxMDM2MTdaMBQxEjAQBgNVBAMMCWFkcjA0c3AwNzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJkolFFF8KlXZt1Siu3gnA5088p2r+6ZUVKRMDFF0olxyI6rJq4LX3xQGAEjX+sVqNEMcrYuBim3mI3UvGgFDHMBTQCTV81aIfBKNtHZxlA45ProxyZsS0QuUfXRYlFnYDRj9OBfgZdMElWzHpiLIyLt9kXOm82SuMx+xrsXZ/rkZRbcY4sKfNmQ4CzoGC5OC+3QtzbZ7b4AVtwhQ5srxwHc9Y69kI1qLqU/sCmdS7t7vTkrPX8cNfQ6PAS2GEju8GAx69Ub5Vvp9Jtp39uRok9fL3oJszdPx/C24bNdNvds1SMvS6L2fWKQOJCxZQ2MYHeErzSQwtqSHrpczWlvfmsCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAFwN3Z5K8txG3drufVypKVdaUd0K6tzSn6beXSWaGXQkegGrMvXmrT5sSzJCFfrQUInFJQ2azLmuIrxZdkGkfpppVB/e96BvP0cEZlU4b6pS2yGGxmzhXWE8BztQic3tVa/xv2w2eVT0+IC5QZmwSMwRM9E9oTkAZsBnkdirMS+13MAv/vLv1i7POM29fs72/vzCRULU1e7eNzm0ASwitLO5Cq8i6NqBsjs8geWXnG8QCYXXakZMGk26zK7lvkufTiY3tspIvamN4+GR+TLAVxjx1p0R+xklGAZsoxZIJi9PccoXxx0TK3Lj7LUnnWVlRI9bEX047cMOtePggN8+68w=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr07sp11",
                                "PS256",
                                "s591dn_lDCI0WQf3Qy-abgUVkebZ6qfEV8lUN4sKmA701PMMXxF0up0Nw2sz9VS_6rSCK5CYLW9Fj9MmqAH8OThCOCmZ28OE5GMfP9QRP9yZt84R_Tisw4POOJHDvSIPE_qjGeW1xgGMt-2JtouwgfqkGZKNSncIBimCZK-qtPgvr1Jcq7upRUJ77mkbXKjw38f_QKa2DAIPy1NEm8Gx_WwrvpGTQhOLAvZKlLrXieE2bMToza0L4d1bbpS17z1bmgDVKpGUjChn9G8vK0KMx4cwfNuP0NGC61kWcig82za2OJC2IJtbY1dNC2DyXK5TdLW7RX0rkF1R3lkIlqChYw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevAE4UMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA3c3AxMTAeFw0yMTAyMTcwNzU5MjhaFw0yMTEyMTQwNzU5MjhaMBQxEjAQBgNVBAMMCWFkcjA3c3AxMTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBALOfdXZ/5QwiNFkH90Mvmm4FFZHm2eqnxFfJVDeLCpgO9NTzDF8RdLqdDcNrM/VUv+q0giuQmC1vRY/TJqgB/Dk4QjgpmdvDhORjHz/UET/cmbfOEf04rMODzjiRw70iDxP6oxnltcYBjLftibaLsIH6pBmSjUp3CAYpgmSvqrT4L69SXKu7qUVCe+5pG1yo8N/H/0CmtgwCD8tTRJvBsf1sK76Rk0ITiwL2SpS614nhNmzE6M2tC+HdW26Ute89W5oA1SqRlIwoZ/RvLytCjMeHMHzbj9DRgutZFnIoPNs2tjiQtiCbW2NXTQtg8lyuU3S1u0V9K5BdUd5ZCJagoWMCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAi/UqiklEMnYkDsrGU1KoAKJ3UTPip8cEWYJ0VDzI9SjOyWV4Dy8U+DEzDe5z72E2VTgHd+qWlywzCq3vpQt4xn+cl7gzdhqVj7W+6q3zhR3mS/DxNa6CxPpvVBfD1Z2eDWAHLCrj5EEMZ9kKs6NgzEvLU1flE0aLgwhDGaS5cb7liXbwr0YXuGmN7RaDW4V9pSvV9TQXJqxyHWv1TRJBWLSR10gwpyAdfnakwR5RsCDpKSO2vWexnJz9IM+awvWeagbxP1SwJWB90LqOhgduqWgeYzBPCehQwvP55TIyCGI4xlxOwACjBBAnmtcEGffrlfuDWx6HT/6smKoC1/SnOw=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr07sp12",
                                "PS256",
                                "nsWPU0gqB9-tL6CKMGJVRX7yMdcEsGRo0bYKVedaBtcQQUrPVe-u86c7ViaKnSEMgbbMXMQlHIbWMaz2I12IvOGQ9oG6ztEb_L4RtIu1vJWXoRbb3fxHG_MHQoGi_FSf0TTtssjCJQL3KSX1_gYzRqlQyQbjAiQ0PbYdqehq5b2-rJITo552e67HEnZugpbijOCWFHsqa2zTR7TDXnyT7iCDuynpT_PtmDCq7hLvjAZSNvYeRON2HvRh8VI1ezERvwAOUF3jdLK3P7nuYHhtAK80YDpjTbRP-uhXOGd5W4Y58Hw9JYe10B07dCHuVA3NJFT1lI1sV5iYnLDzCdwNyQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevBBlMMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA3c3AxMjAeFw0yMTAyMTcwODAzMzdaFw0yMTEyMTQwODAzMzdaMBQxEjAQBgNVBAMMCWFkcjA3c3AxMjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJ7Fj1NIKgffrS+gijBiVUV+8jHXBLBkaNG2ClXnWgbXEEFKz1XvrvOnO1Ymip0hDIG2zFzEJRyG1jGs9iNdiLzhkPaBus7RG/y+EbSLtbyVl6EW2938RxvzB0KBovxUn9E07bLIwiUC9ykl9f4GM0apUMkG4wIkND22HanoauW9vqySE6OednuuxxJ2boKW4ozglhR7Kmts00e0w158k+4gg7sp6U/z7Zgwqu4S74wGUjb2HkTjdh70YfFSNXsxEb8ADlBd43Sytz+57mB4bQCvNGA6Y020T/roVzhneVuGOfB8PSWHtdAdO3Qh7lQNzSRU9ZSNbFeYmJyw8wncDckCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAgP9eQ/enpgmajpIEgCKYV8PcxYdWFCMVxxh65b82BziReL1rZlRZ3W6UvuyysV6O9cpWo4qtEk3tgl0+mZ8v7nAKjYIs4R3DvRI3PrcRSKDxEh6NlqpI4gd1CPH7xBVOrR6FtUihh9hZzethtKHwnSCg4AM4ClM0AX5z0SyxXcLHy6UnSaQLcI6rAnxrBH9EOCRnMs3hMmrODU5+vhRcWLFmRiFcPodqBC4Zoy5YU43ZRQMBY+RZqbOh5NEHQZNcFPNU2g052Mf0SqMdwWvRFZ/neA0Xm9CdYGCYMipN/KEqFOG6j2U8D0eXI87D94ybBv6xxON7W/+cATJusmM5CQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr08sp13",
                                "PS256",
                                "wC3kDhEo6rWJaFIpanEBkCpS_Pyld-mQG6sNc-tbY7udBGpo2bMq78OewNbVZVvwkkFWfTzcdJacFCIt_m8rf0Dn5fSGiQHhuI_fA5YdMdBdiWwt556DmAV_3sz9hEQBJ1GKyaYpXoRwX56xnq_aHyH0YQzac0eRPAcvh7sfKhkVoWq6yLuf3tekX74NRnBwWf6exO3IC0Dzxdb52MXGkxRNqiH4-8pDfhLS9C76QLiwPfYxN1KWJdEBM89oBa_uOiFd2_ZPAlD30NNkjrrJKH3XUUgRFPLh5BxO3bExhYDg0ZCulyfEVusqCKPOBPDz2_wzEhWVMo1zaAF9Wqsg1Q",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevBkCzMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA4c3AxMzAeFw0yMTAyMTcwODA1NThaFw0yMTEyMTQwODA1NThaMBQxEjAQBgNVBAMMCWFkcjA4c3AxMzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMAt5A4RKOq1iWhSKWpxAZAqUvz8pXfpkBurDXPrW2O7nQRqaNmzKu/DnsDW1WVb8JJBVn083HSWnBQiLf5vK39A5+X0hokB4biP3wOWHTHQXYlsLeeeg5gFf97M/YREASdRismmKV6EcF+esZ6v2h8h9GEM2nNHkTwHL4e7HyoZFaFqusi7n97XpF++DUZwcFn+nsTtyAtA88XW+djFxpMUTaoh+PvKQ34S0vQu+kC4sD32MTdSliXRATPPaAWv7johXdv2TwJQ99DTZI66ySh911FIERTy4eQcTt2xMYWA4NGQrpcnxFbrKgijzgTw89v8MxIVlTKNc2gBfVqrINUCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAGBVdNkXFddcNpZtdAhPSHkqFT3VLLjCt6fZlcLOzoKhCVaVniCKJu45eW3IH9jMErfjnK5LJkRWIHjHYlY6baGKK7CjRUGJygYH4A5SHBEDodNYKOHXwx+HyOaLfi7u8+jlKLI9BQtBreadjRxjmnAKgX3JAGXiOQ9IEFFRPN+WRkoPjCP8TanU4heOJdNb7r8fofGLpEy1L8E3jX06gEqB5DCKI5kk9GTBFORqsurCPk8sa1wZ/nFfCDI0CWaar6JY7CiESlBxH2yeWsudTmDW7tF8NJlEmzDKPHa3NL7zwMrUxjcbohcLtoCDQSByY7uOrBNwWmL6IZBq9By0PtA=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr08sp14",
                                "PS256",
                                "nHOtaKdgeDlEzHdvaiTOF0jfheR4I1VRO90zl5rjWH4Y80MMIYbASyO0Jydoh597Ry0NBkhrjlpINKBuKm7LQwmcvCYuTHak1z2Z77qzqDaXlBZ6wwcZwRT6l3PdPmH3nt0sLsfJ_OlsE3eYavhQbiiH4brs7ZL2J__TRXcSSdWJe9_NWryLUCf9oA2W8SM_x62NmqFWUgDemfN7VDsCo-FfV1E00Kaqx-tVhCa4EUzclFqfJHveJuPQSgMHPc9eTRBFJNix-7y0ng-NXpfPlYYT-TjaHpQs-Sf0QhJbcWnM9GTGGGdDq9_3egh_BkzJRKxTZFz17jLPKpbzhfD_qQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevCDP/MA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA4c3AxNDAeFw0yMTAyMTcwODA4MDZaFw0yMTEyMTQwODA4MDZaMBQxEjAQBgNVBAMMCWFkcjA4c3AxNDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJxzrWinYHg5RMx3b2okzhdI34XkeCNVUTvdM5ea41h+GPNDDCGGwEsjtCcnaIefe0ctDQZIa45aSDSgbipuy0MJnLwmLkx2pNc9me+6s6g2l5QWesMHGcEU+pdz3T5h957dLC7HyfzpbBN3mGr4UG4oh+G67O2S9if/00V3EknViXvfzVq8i1An/aANlvEjP8etjZqhVlIA3pnze1Q7AqPhX1dRNNCmqsfrVYQmuBFM3JRanyR73ibj0EoDBz3PXk0QRSTYsfu8tJ4PjV6Xz5WGE/k42h6ULPkn9EISW3FpzPRkxhhnQ6vf93oIfwZMyUSsU2Rc9e4yzyqW84Xw/6kCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAdokmPdoXttVUuXg6Cx9YGGxVeStXscUEPCZndqZlMiPhKGTotWn7OU4mLTYRe392WC4MJ5O9UkA56Uyo4znzjDt461LQZIyMzwDw7mmpM1TQoUf6m4FNLKQdeCX4jdPEj3GN161N72pMFqgKn4Fr9u5xav6+jYmNbRgx4/McFBDPWACiDlef6qF5sF7x3IaXvi3aQcjDQ17N2l/BDCJSyPx17K1nVzaGuyOccgKt+dX5dpI/lVOqkUI+bvlsxJwqzlNw6IXHeV703R6EYT+t9k9BHrQ/AR5PEEjig/sMii61IAKugdNs+gT1/rkjrtj4JbIapbYOegrnmK/V2RTiaw=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr09sp15",
                                "PS256",
                                "nUbeRYvNbi9oLcpzhY_D49aTgcVrGP6rIvVMe67YoCT2CiNykltM1dV1AFVeFg_FJSj77XpDzFJD_PR5kMpz6OG1JH6dEHCWgjM0SGcxY3AriHd4vpYW7_WAc4WkgpUESwbtKuVABrCtIpUNhDUL1gKsT4TK6Af3PRHkrqCwrq5SXAHUm2BKtbOaWXshAyjwz_D6j1kBnbeW277HH92I0pdSurnOt_T7Ii8kzh0-_bq20hIURcDz3T5lHnkOFe6phnap5N5jbOcvjmzgY_bNw-lSet_7Kwgl51qYznteuaAHhO8tvh-vF3EcSfzmMcC4MpFXWNYLV9sF44W8cwX5Kw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevC5vmMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA5c3AxNTAeFw0yMTAyMTcwODExNDlaFw0yMTEyMTQwODExNDlaMBQxEjAQBgNVBAMMCWFkcjA5c3AxNTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJ1G3kWLzW4vaC3Kc4WPw+PWk4HFaxj+qyL1THuu2KAk9gojcpJbTNXVdQBVXhYPxSUo++16Q8xSQ/z0eZDKc+jhtSR+nRBwloIzNEhnMWNwK4h3eL6WFu/1gHOFpIKVBEsG7SrlQAawrSKVDYQ1C9YCrE+EyugH9z0R5K6gsK6uUlwB1JtgSrWzmll7IQMo8M/w+o9ZAZ23ltu+xx/diNKXUrq5zrf0+yIvJM4dPv26ttISFEXA890+ZR55DhXuqYZ2qeTeY2znL45s4GP2zcPpUnrf+ysIJedamM57XrmgB4TvLb4frxdxHEn85jHAuDKRV1jWC1fbBeOFvHMF+SsCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAa+Zp8eCdaiHlNGM/HWdvDbG9UsU9B7GjSOg/eQ34a3xOVl22+yW5GwPPAhGYoBUsycp3TRBpAg05Nm5/W9R9J3tk4bcAV7J2b5m/NHEIFPhnFDz8fniveNEx+JAxu70P/QXfKSsC5zjfy8J6CL646vz0JVFL2577mFGMedSeEwjcqogCy3FSkeb2ZXkFt0+WKvGXEls06EZ/27yupfKKYAHHalAdZXxBuPWHQBo+smt1XhaNcNgWpJy+lv8pq1U3Am/qoIbSSpKC0D2YqajwKO+PPGEn6G3F7VUr8zsYrNrMl8mxujtnMmr3heBoIF18hpaHvMTFDb+d/7my7Pgaqg=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr10sp16",
                                "PS256",
                                "l1NfutaDvMIrWAxoDjmV7K6eGYtLgNQ3ZUUyww-xNLPoW5ZhjJ4ya9L_4j7d8JnVvR9gu8zdqemHxL9Vq4YhkIseCi8ntNjovd2quqY4vlpnLXjFNN1uHBVfqHUgI1rvJN2lhAH0HiZU-jYlooAP5mVcHaSLICpgsVWKlmjiU4bhKoMJ9VA7j5cAEHYj7ziTeq1Gj7dgvljFsMemI_JNZLPJVarl8g268-boxJ1zZKLZ16YV2DZmX9imBROK9BsBMM87iXRzsODXsw8W8fptZCO4frlefK5RaREzF3JXIb2_fEQINiBUutYBIfOQ-gZm180ZOj-kLyYv0TUeSSPvWw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevDXrtMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjEwc3AxNjAeFw0yMTAyMTcwODEzNTJaFw0yMTEyMTQwODEzNTJaMBQxEjAQBgNVBAMMCWFkcjEwc3AxNjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJdTX7rWg7zCK1gMaA45leyunhmLS4DUN2VFMsMPsTSz6FuWYYyeMmvS/+I+3fCZ1b0fYLvM3anph8S/VauGIZCLHgovJ7TY6L3dqrqmOL5aZy14xTTdbhwVX6h1ICNa7yTdpYQB9B4mVPo2JaKAD+ZlXB2kiyAqYLFVipZo4lOG4SqDCfVQO4+XABB2I+84k3qtRo+3YL5YxbDHpiPyTWSzyVWq5fINuvPm6MSdc2Si2demFdg2Zl/YpgUTivQbATDPO4l0c7Dg17MPFvH6bWQjuH65XnyuUWkRMxdyVyG9v3xECDYgVLrWASHzkPoGZtfNGTo/pC8mL9E1Hkkj71sCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAAezwU4PjeImPTpgiiAzbQqk1LjZe/WvKo4XlNapnLUAwx9Ixa2+WPJRTwtdWFyhlbLVm0r7tnzhIe8Wse1/2wrYnTZTi1pFAPqIX77falT+EMAf7Jv45rHoDUezWiI8Hh/TTXsPnyCNk5ACnJMulCpGU3d+yqE7znD9V+wB52aVBOK+EwRi9sGkQy0bNWAmy7Xa8JyA3ixTcLhGJEYTfd/B5O4PHVBPOEMHrfJBG7v2tBtf3F/HdLXCzCLIft4Xdq7XP/+9CY5bsV7vDqLmKyguNtYMFCXzlWJE4oxIckX6I2hFEKhBEq/9KOa/SEbOBTCzIclwiv3y7mE1XCTNSsg=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr11sp17",
                                "PS256",
                                "hXXXYcwXZ2PBeFPVtPclzIppaX7iNEEn4cESEcDSCY3J_jVO3B9CXj7v1Hsjf_SzX_EbnohCvJKmcjag9zDVD538Od72vIskrqWiVqOqzxZt-xD4hmisYvuvgkryPZGpjM7xWgWnt4Il1s26XtsxS3WtJQer8A5hcRyQ0eB2ProF_P1Twz4jhYX6dmHMMZ-5CFlWKp8cqJbD3ZYruEkjux0ng_CRFdZbXb_up00EitaKGN0BIzBifoCoHCNjuwBtzHFnBbrEhHMb9Obj7lRQ5y6fofZ5Z8R1euJZ6s7a-tjR2a5dk1O32OeKHuJg9May9AYiSpBL0StbDtX0FZ4v5w",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevDxR9MA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjExc3AxNzAeFw0yMTAyMTcwODE1MzdaFw0yMTEyMTQwODE1MzdaMBQxEjAQBgNVBAMMCWFkcjExc3AxNzCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIV112HMF2djwXhT1bT3JcyKaWl+4jRBJ+HBEhHA0gmNyf41TtwfQl4+79R7I3/0s1/xG56IQrySpnI2oPcw1Q+d/Dne9ryLJK6lolajqs8WbfsQ+IZorGL7r4JK8j2RqYzO8VoFp7eCJdbNul7bMUt1rSUHq/AOYXEckNHgdj66Bfz9U8M+I4WF+nZhzDGfuQhZViqfHKiWw92WK7hJI7sdJ4PwkRXWW12/7qdNBIrWihjdASMwYn6AqBwjY7sAbcxxZwW6xIRzG/Tm4+5UUOcun6H2eWfEdXriWerO2vrY0dmuXZNTt9jnih7iYPTGsvQGIkqQS9ErWw7V9BWeL+cCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAJIzW6WaG1OlqwU5WoorDatTEi3RCnNA+5Keq4W8lXJ9sKt0Y9XLTydYw+Rn2w5UQ7/M/RUcbYSzw/cdTLGTy706OEZqjDsCQunsj/f1BphF5qDES+gZD1a9X6PUajNUT8qqv3xKv7ecMj4X6jI908f6AJw8ZSMHMvWV8qeYFWtvgy71frqi5BLW93wNH82OcvoKjhk1HkEaTkcSlhmJMrLYJr4o7rJ6huKHout2qkqxNPbcshx+Xo/x6rO6wOsd+uBLnceiDnfLklTjbF07zLama/PckCcXCN7BTipLMR9zWChXQnhIYIxTN1fmulztLHWSIbj02Vy2SqmMQPGOZVw=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr11sp18",
                                "PS256",
                                "qQinKxvnEPoLdXJqH1oN5JIFNzxK_SpncdbYCdBmsOPd_FXGMXOA3P8B1_kAUVQWx8bSVHplyZqTvpBLh6dWtJaJgSKNnIAlNoci1YOSeK_-gFztbMMLLPQ9K0GjVANbqfH_pTCjjz51UlesmiRHL5E4der7pmgqxVjMEedWCVQ-CSbWEJIBLNGKbYFET0dIcn6BwKosuehijWPVARIgDOGJ7phXESshpPS9pAPJBu-EfrNy9XZv2Z545AEk__3qQqWPyL0J_FGy1omotN4d6ZNhXYQb0jnoiKWJXE6w4C26wXUQ_09FnwCDr86ermE9wrwIUh7lT_yoOOi1WcRIBQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevEKc+MA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjExc3AxODAeFw0yMTAyMTcwODE3MjBaFw0yMTEyMTQwODE3MjBaMBQxEjAQBgNVBAMMCWFkcjExc3AxODCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKkIpysb5xD6C3Vyah9aDeSSBTc8Sv0qZ3HW2AnQZrDj3fxVxjFzgNz/Adf5AFFUFsfG0lR6Zcmak76QS4enVrSWiYEijZyAJTaHItWDkniv/oBc7WzDCyz0PStBo1QDW6nx/6Uwo48+dVJXrJokRy+ROHXq+6ZoKsVYzBHnVglUPgkm1hCSASzRim2BRE9HSHJ+gcCqLLnoYo1j1QESIAzhie6YVxErIaT0vaQDyQbvhH6zcvV2b9meeOQBJP/96kKlj8i9CfxRstaJqLTeHemTYV2EG9I56IiliVxOsOAtusF1EP9PRZ8Ag6/Onq5hPcK8CFIe5U/8qDjotVnESAUCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAIv5xrzJPTF/tSs7/EiUvyBr9NBXx9bJguAwGekJP/pXeDjujn35hJ1lHDcUT2FSmahyPvQt8xEY+HC5HrRMK6CMkw+9cwdR1o9XXWw5fy3TfQ6gWlA5ii1j2JG9uxhTKdUJZNAJ8S8vpUZuMHgsqRSw7LaPGVNX+vwpqJHsVGG7zgXSwRtN58rjPeozvqcRp3XpavPYgt9nww83gQB5+Wj02g+Z9pO44K8pLHG/tKz4XGZBgsK6NsgOduV8ILH5dTg1/xAwi9lVLYih2RyxVyuEyu/d1erlw0cxBMRbN/26ccHma25XDe1qycHKvbqOfWMmtcIGsbTopEZR70yMryQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr12sp19",
                                "PS256",
                                "x6Z7UaRzkt8c29p7P0Grn3jik8EjUT0mwtNvwDJhBDJci9JeswGHXPu13blGyEQqnXe3qW7FMzYC3ol43D80z1cI0GzWSEFrwDSz5klZS8fiS-tNk_YRbRpH1VMjxpDmQohJ_K5jqqPHcC6BFEIt4xrmd-uDyHFQUrWx-bjS9lOSlzVz-y6nCBpWB3dGBF_H-LF2d2YOVA3ZWLj00ThbkJ_sJP8zZ0AEkJ_RBuN5niGMKnaSTf-olXPHLARjzO6y7KynBOw52B17c-qSuesJhVZCklYtNJeP4l7tvhypY68Fxe2dAKqUQZPgXVdWo1cBK2jYdcKTuJZAaLNYo-cVAQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevGlIEMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjEyc3AxOTAeFw0yMTAyMTcwODI3NTNaFw0yMTEyMTQwODI3NTNaMBQxEjAQBgNVBAMMCWFkcjEyc3AxOTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMeme1Gkc5LfHNvaez9Bq5944pPBI1E9JsLTb8AyYQQyXIvSXrMBh1z7td25RshEKp13t6luxTM2At6JeNw/NM9XCNBs1khBa8A0s+ZJWUvH4kvrTZP2EW0aR9VTI8aQ5kKISfyuY6qjx3AugRRCLeMa5nfrg8hxUFK1sfm40vZTkpc1c/supwgaVgd3RgRfx/ixdndmDlQN2Vi49NE4W5Cf7CT/M2dABJCf0QbjeZ4hjCp2kk3/qJVzxywEY8zusuyspwTsOdgde3PqkrnrCYVWQpJWLTSXj+Je7b4cqWOvBcXtnQCqlEGT4F1XVqNXASto2HXCk7iWQGizWKPnFQECAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAxFTB6bRQKig9x5a8uEbz2GRyR8z4FUM6e8AoKVPWYg8bGIdqfO6imqr4YwOVVBFnJKgv8uSKU82ddqSzXIkuOtW5KLhkhceGhi557IgOl90ervluB36aQ8kUVpnNy+rnu/NUb3D/SxMsq/2I1STQ34EMasADhYw7tcUlw7nuavj4zalcyoDpZqBd2lTuQVOAbSIu9wzgt7WDVF5TCBLC99lE/QZSw3sqKmEtKp+/g+ayjkCfY3RvmN9NwDj0IhIEXvuf1iw2Igi2zfNSqTE6eyKsYv15V746ZLabmvKN/Jn6Z5g9XN1iGBBwEvzfsZ/jn689iepgqt/6uevrlw+2EQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr12sp20",
                                "PS256",
                                "rZ7AD4-JXDQPkrresT-uh7fmhXbOjWTSVRCnOpH-W41HEDINFNRnQBhVeNnVqt8Z6OytMriuq8Y-mfERwYCvix39QfOV19X8Nq6YU-ZVrDGC0TFlnt8RgL12Qwhey0-Dui0zcpGfzV4CRjbGADsFONBO2p1bPujYAuqeb2OBsjFW6XYJ7fufe4QwdmUiXcskEzOkgdBYXsUqaJ4lvY6TsKNkP7FLaH3aXOEr4gZO1htSBzSInQI1gqDwlI4qA3t3z0gZMhGPBtSc5qTiQwSI7yTRXB7CpgM_P5lKCV02nnk2u1LM1xD9pJnWv7R4yY9W_apAu1t5h1yOgu3vaudrjQ",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevIVrWMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjEyc3AyMDAeFw0yMTAyMTcwODM1MzRaFw0yMTEyMTQwODM1MzRaMBQxEjAQBgNVBAMMCWFkcjEyc3AyMDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAK2ewA+PiVw0D5K63rE/roe35oV2zo1k0lUQpzqR/luNRxAyDRTUZ0AYVXjZ1arfGejsrTK4rqvGPpnxEcGAr4sd/UHzldfV/DaumFPmVawxgtExZZ7fEYC9dkMIXstPg7otM3KRn81eAkY2xgA7BTjQTtqdWz7o2ALqnm9jgbIxVul2Ce37n3uEMHZlIl3LJBMzpIHQWF7FKmieJb2Ok7CjZD+xS2h92lzhK+IGTtYbUgc0iJ0CNYKg8JSOKgN7d89IGTIRjwbUnOak4kMEiO8k0VwewqYDPz+ZSgldNp55NrtSzNcQ/aSZ1r+0eMmPVv2qQLtbeYdcjoLt72rna40CAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAANgvbbzpPB/h52WGFbqeQHm0WSSmyd+uinBCAwdYEd9hAcknc5hB/SKop4iBO7Lzz++tCPWnCWrXinqHN1U7JsGl2I/60HU2QmrpRwQ6hzqN0G1ga1/Od/hmMp75g5oaThhJJadjm+20pWeDTVmHkAql+QAZz8Uy5ubJyOEBafFHoLNQjVlxbsrzvbyayxpWLjLLRkf/81KqmADbUJNp1dq9Y66r+jPm+qVcLYZdXU1WyOU/+6ZpQLAqNyLmy01s0f3ZnfwG4G/W7DtDwdLWvdOJctmM7ZY9PRpSShIv8NJEzUBfDViqvZX0Kt8zO9/bp/ZDqhZ8hM/Y6FvCnBVfLQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        )
                )
        );

        return ResponseEntity.ok(jwksDto);
    }


    @GetMapping("/adrrevokedjwks")
    public ResponseEntity<JwksDto> getRevokedJwks() {

        JwksDto jwksDto = new JwksDto(
                Arrays.asList(
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr02sp04",
                                "PS256",
                                "p6A1eDTixohTG-6kaRaXLC_C8B5sE1Mrl-u5msT5k3TgbikiUGyK1k8rz8osfcOYTtDjejzsut3j9BAY0p-8nO-6h8CqpG777zNJNbGM4oJQYLQXxoVrFROxDsZ0g8anFL76Pid9u-Aw3tgpJJbu3CHTShoP5WdcDW7xBsvI18ZavA4g2M5YWYMZpXvkAJwnO5ZS2P-zxpGUbu-dvLyVlrOiLlRFIepHeX8pxS9Dv7dRaKz1u0aJZQ8kKxTIPtLKx6_ygYtaUIVVuqZ-sytp-QlTLBiqgixaiF9IiSPBjynoW8FDduMtLfcGZZe5Fqgsh5vdEY1108NTmGy1lYDh0Q",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXd7csiMMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAyc3AwNDAeFw0yMTAyMDcwNzQ0MTZaFw0yMTEyMDQwNzQ0MTZaMBQxEjAQBgNVBAMMCWFkcjAyc3AwNDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAKegNXg04saIUxvupGkWlywvwvAebBNTK5fruZrE+ZN04G4pIlBsitZPK8/KLH3DmE7Q43o87Lrd4/QQGNKfvJzvuofAqqRu++8zSTWxjOKCUGC0F8aFaxUTsQ7GdIPGpxS++j4nfbvgMN7YKSSW7twh00oaD+VnXA1u8QbLyNfGWrwOINjOWFmDGaV75ACcJzuWUtj/s8aRlG7vnby8lZazoi5URSHqR3l/KcUvQ7+3UWis9btGiWUPJCsUyD7Sysev8oGLWlCFVbqmfrMrafkJUywYqoIsWohfSIkjwY8p6FvBQ3bjLS33BmWXuRaoLIeb3RGNddPDU5hstZWA4dECAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAR4zzwXVRFEnf3xZ8JdBu0nS2EhNgctU0JFuuqvIyl6f4WQCAAgzoDlIdnJ+2TkmtgkiYmbnhfWfga6FHz00aJjuGyfvdidvKzxX2sixU5ROU1+cW27d1mhq6bYwtbj/O77yRaT4rlRHSGrNRIEj4JMl8gNuED/sVf2R3YTslYY1yzVghd1ywko7i5o5OhkfRwCgCjCBHGGxmcOkVqI3J6Ydy9yppzvFlnJjxBxoUjlgTscC79z4L5VXIi5n+xDdRqyDClBaTNjfuGDviitWVS+Bj9+8IyYC0B12RZb/g3ehAnIvec3U3hRgMEmHSv3Za0HD09mJkU/dAWYhKfgXkug=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/revokedadrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr03sp06",
                                "PS256",
                                "k5m9pkICfOnTLu_N4gd4o44RywOhA1RiWUcRzq5eXdCL3FdnPdhlM8NoiuUFDQS5-VKm1OygL1KQTm4gP6ND52Jb9Pk6bZ8yQskE5epzZl4jWrLZRSC_s0SQLVaQDWqozSWSoX47RmDpKqTNbQNm5-3toDHB8TbFtjzNuFt4NsYSB2rbMhcIWPCp36BkTzfjmpvI2ub4rBQ5PYGcQDhZ58uzue622aAc689pI4S7U1Uly6AvYyhPqMzcf_0H7JAHkjm_x3DfToyV2UWUmfBWuYOR6usvN4Ug_wMjiY6qJivkELgslAdp8cYj0wp1uvJFsdXSfzROfqqahPm2-K7hvw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXeu9+fFMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjAzc3AwNjAeFw0yMTAyMTcwNzUwMThaFw0yMTEyMTQwNzUwMThaMBQxEjAQBgNVBAMMCWFkcjAzc3AwNjCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJOZvaZCAnzp0y7vzeIHeKOOEcsDoQNUYllHEc6uXl3Qi9xXZz3YZTPDaIrlBQ0EuflSptTsoC9SkE5uID+jQ+diW/T5Om2fMkLJBOXqc2ZeI1qy2UUgv7NEkC1WkA1qqM0lkqF+O0Zg6SqkzW0DZuft7aAxwfE2xbY8zbhbeDbGEgdq2zIXCFjwqd+gZE8345qbyNrm+KwUOT2BnEA4WefLs7nuttmgHOvPaSOEu1NVJcugL2MoT6jM3H/9B+yQB5I5v8dw306MldlFlJnwVrmDkerrLzeFIP8DI4mOqiYr5BC4LJQHafHGI9MKdbryRbHV0n80Tn6qmoT5tviu4b8CAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAdU4kSEIZvQlwQUhV8JlsQIyCkpaobFfOEarLShLxNf+qJqdXvhLfxbv4tWmwxZgIuIeNZ2kfALjTWc4V4WV13jB3G0xSYf7HYadFnO861HDAAoHHQDi9wmnwFiQM9x7rLF9F/u1K1T+YvExi/jy1TPfcAdLXBf3IU89lS0XmARJ4aJ1RSFP4wtm+XMGihwr3hejYyjF5Xb+7t68KbysDtPmdEe17Igf7uoriEr92w/g7iC2Ey0sE87mTLwWvJWeM2gnS7WRqSuZAU5HSv90lbW3SYpqd92JQ/RmI2W5PKBpqjQzCcFRH2yIwWtjsjS+CG65Ug+ndOQ+ovBDpAoTpdw=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr04sp08",
                                "PS256",
                                "gTVyCpQoEY6PD3sQfhyY062yN4cmJkT3-e_ywDCR5Joa_9SrjvuV0prKuQYp-dnv39THvpJUviBIgecAvS2Gl_EBAgiuyo_fOj6lcWGcmPU3px33v3qsfPqMDXSEYSQYGGFODSFQG6MgHpjSPt2mySQ00ULpHPB6H3IdOf9qvjCQeUZo52PF0Jxv95nTvSvS7gpmWZ8aI6hiT8mOlVN_oF7qiN9ru3IPgPeuOKSSfijdJqmae9-d9uPvM1COsse6dmN26U1DJPCdG8FSQkEl3unUoxhk5_n7SLo1UYbZR11WlG-wQ7qSoQYZhmpoIWzVIu1Ba7WRlhsTqZOlYzevRw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevkibeMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA0c3AwODAeFw0yMTAyMTcxMDM4NDdaFw0yMTEyMTQxMDM4NDdaMBQxEjAQBgNVBAMMCWFkcjA0c3AwODCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAIE1cgqUKBGOjw97EH4cmNOtsjeHJiZE9/nv8sAwkeSaGv/Uq477ldKayrkGKfnZ79/Ux76SVL4gSIHnAL0thpfxAQIIrsqP3zo+pXFhnJj1N6cd9796rHz6jA10hGEkGBhhTg0hUBujIB6Y0j7dpskkNNFC6Rzweh9yHTn/ar4wkHlGaOdjxdCcb/eZ070r0u4KZlmfGiOoYk/JjpVTf6Be6ojfa7tyD4D3rjikkn4o3Sapmnvfnfbj7zNQjrLHunZjdulNQyTwnRvBUkJBJd7p1KMYZOf5+0i6NVGG2UddVpRvsEO6kqEGGYZqaCFs1SLtQWu1kZYbE6mTpWM3r0cCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAF2cJiy2tDNVogakPEGvD3HA+JJsxIZnU7TSQZUTBBY7QfElxHY5dp659fHqIisWvgvLGb2hrup5eAHN0YsuhQDIR5rYV4XFGR2VFOw602WyWxC/nzsv4O5iOBlbEDHjF0ihFgyM6/lusncyL/L+3UEVD8jds6m4Exot1qpedFvJ7q9+YF8ET/lqXcF1nw/wiqdE2SMm1+HundEWM9qPsV/jPbJwC+ty8w0U3PaCLtYVYpAxdZEHIN+zHAVCLO/ZeSHfpw9tkHK5ptLrkwcnTX6VfugPnfgZ6Gb3GOUQAl/NIhkp9HZlckSCDkjXuHCdhXgaBG/L3F2QcnFuolfWgog=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr05sp09",
                                "PS256",
                                "n4dZu5pAsAXerK-aR64ILRBG4FBVEOM44tc1Q-9rQUBRBkr8WExNPOEYl3zRSXog93SrV-KEcIsNDVmeVQ6UQ2zXuNQ7H8d7VkDM5-vF6CqfjzRgoTsQCiE7Aq3Ok2QcL3APxZn5icajFmckHJa7OzL4VVLV47HDuIlFcmm_B0Bre0bGEeS7G3C_hXSWWVAkT6eiRTMyg425NRoys3Nz32KUI5iELzWSwh5HR1UamEjtxgT1N9DIaRnj6TKbUD12AsBSDa_UFPizY94oCcCoir2xMpQs3NhAY_QDWsNyqfrafxQ9bNpHj4QVecLVOkTORy0Hoy5F4-DaPPHt4pTVvw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevlVPJMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA1c3AwOTAeFw0yMTAyMTcxMDQyMTVaFw0yMTEyMTQxMDQyMTVaMBQxEjAQBgNVBAMMCWFkcjA1c3AwOTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAJ+HWbuaQLAF3qyvmkeuCC0QRuBQVRDjOOLXNUPva0FAUQZK/FhMTTzhGJd80Ul6IPd0q1fihHCLDQ1ZnlUOlENs17jUOx/He1ZAzOfrxegqn480YKE7EAohOwKtzpNkHC9wD8WZ+YnGoxZnJByWuzsy+FVS1eOxw7iJRXJpvwdAa3tGxhHkuxtwv4V0lllQJE+nokUzMoONuTUaMrNzc99ilCOYhC81ksIeR0dVGphI7cYE9TfQyGkZ4+kym1A9dgLAUg2v1BT4s2PeKAnAqIq9sTKULNzYQGP0A1rDcqn62n8UPWzaR4+EFXnC1TpEzkctB6MuRePg2jzx7eKU1b8CAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAbUyfUJcPCUikWwvL9mIEu9oN+smrJn67jz4bCXC5hu5RSEgewmvJ0uyaEbfoiQk73iYkW+mAhgSng/nc4ciKhqQAGWUp9hDyyP27Ulc+QuNO3bcUKtV8CJ9kvt9mOpukse2tCKoJ74AZKiGOs7cQop83AlbzK9qiCCa/I29IF0a2Uj+eoOmIqae2Jqzi2EalW6S/lh4enyccvdWVIodDfpIl6GaxQcQUjVWTpKYUBjZ+fPjuARl81qdp/zL1yrLKqwst9R8Rgb0wXbRFnuHls9mI2nw8ZbTyPUiXcmsOgsuQqRhsNdKvRbtCX5UG7Hsj8ySf9ksoLMYt7N43vGRzXQ=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        ),
                        new JwkDto(
                                "RSA",
                                "AQAB",
                                "sig",
                                "adr06sp10",
                                "PS256",
                                "wRLjPS5Z-9_iYW9h5Nxz_UT99tMDp7nT9Ezogc7zwPlGtFLBWpcWKS96esrjGxs6bR893rPTgyRbDKQg2Lw3yVOhyV0nee9cMnuz9DckobbzZduB882nrrnfy37DapWkNSlpYGVmmmX49sC2OtiwS2MxkzY5JktGOoJXk_G1haHyB6lvsCm0XaJxG-xNxig0B4gBs6P7lapj73o-NGsqbyn998Zr3DN2rR_ocCMR9qXU-GtwKr3F5UmYMaVbNYJ5eAlTucHuBD571EPGseFJq8zw1b9FMbKzY56lTrBCG_8dRb3bbWeGxE6VaH34Ez1MJ3mSqmlxr8UZnFU_4WQGUw",
                                Arrays.asList("MIICpjCCAY6gAwIBAgIGAXevl3NDMA0GCSqGSIb3DQEBCwUAMBQxEjAQBgNVBAMMCWFkcjA2c3AxMDAeFw0yMTAyMTcxMDQ0MzRaFw0yMTEyMTQxMDQ0MzRaMBQxEjAQBgNVBAMMCWFkcjA2c3AxMDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMES4z0uWfvf4mFvYeTcc/1E/fbTA6e50/RM6IHO88D5RrRSwVqXFikvenrK4xsbOm0fPd6z04MkWwykINi8N8lTocldJ3nvXDJ7s/Q3JKG282XbgfPNp66538t+w2qVpDUpaWBlZppl+PbAtjrYsEtjMZM2OSZLRjqCV5PxtYWh8gepb7AptF2icRvsTcYoNAeIAbOj+5WqY+96PjRrKm8p/ffGa9wzdq0f6HAjEfal1PhrcCq9xeVJmDGlWzWCeXgJU7nB7gQ+e9RDxrHhSavM8NW/RTGys2OepU6wQhv/HUW9221nhsROlWh9+BM9TCd5kqppca/FGZxVP+FkBlMCAwEAATANBgkqhkiG9w0BAQsFAAOCAQEAqU87nWf6olqy1nvce5hsPrLEqVkueBcz9JYmlomrG9C+iWoZq2tCi90kV+IbOS6VMQjfOHyce+pHs8BDRI0I2Z3K8l7/4no4pqBUIV12jlniKtEt1DXY2cEc+CqWZhDublZMx3J7N4hZFY6SvaA1gXLk7JSwA1582rkMDBmekyjmb6A2ZxKaG1DRQgo0a/B7gzS1dAobHTm1P2IlmagTkF6lRlzgVp+BaIfbLeXKG35dZwr9WEkdqvgU/U4IMvPO4T9sZlpMWD5iFRk459pQqTicgg7txEqzdUGRfsKq2s/eb2Ktu842dE+TasgUc4Wc+Klo52PX7AnAK0Z0SQKyLA=="),
                                "https://mockregistry.com.au:8443/idp/.well-known/openid-configuration/adrjwks"

                        )
                )
        );

        return ResponseEntity.ok(jwksDto);
    }
}
