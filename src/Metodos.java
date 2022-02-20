import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface Metodos {

    public default boolean validarCpf(String cpf) {
        try {
            if (cpf.equals("00000000000") ||
                    cpf.equals("11111111111") ||
                    cpf.equals("22222222222") ||
                    cpf.equals("33333333333") ||
                    cpf.equals("44444444444") ||
                    cpf.equals("55555555555") ||
                    cpf.equals("66666666666") ||
                    cpf.equals("77777777777") ||
                    cpf.equals("88888888888") ||
                    cpf.equals("99999999999")) {
                return false;
            }
            if (cpf.length() != 11) {
                return false;
            } else {
                int valor = 0;
                int cont = 0;
                for (int i = 9; i > 0; i--) {
                    valor += Character.getNumericValue(cpf.charAt(cont)) * (i + 1);
                    cont++;
                }

                if ((valor * 10) % 11 == Character.getNumericValue((cpf.charAt(9)))) {
                    valor = 0;
                    cont = 0;
                    for (int i = 10; i > 0; i--) {
                        valor += Character.getNumericValue(cpf.charAt(cont)) * (i + 1);
                        cont++;
                    }
                    return (valor * 10) % 11 == Character.getNumericValue((cpf.charAt(10)));
                } else {
                    return false;
                }
            }
        } catch (Exception er) {
            System.out.println("Erro " + er);
        }
        return false;
    }

    public default boolean validarCnpj(String cnpj) {
        if (cnpj.equals("00000000000000") ||
                cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") ||
                cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") ||
                cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") ||
                cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") ||
                cnpj.equals("99999999999999")) {
            return false;
        }
        if (cnpj.length() != 14) {
            return false;
        } else {
            char ver1, ver2;
            int peso, valor, valorComPeso, resto;
            peso = 2;
            valor = 0;
            valorComPeso = 0;

            //PRIMERO DIGITO VERIFICADOR
            for (int i = 11; i >= 0; i--) {
                valor = Character.getNumericValue(cnpj.charAt(i));
                valorComPeso = valorComPeso + (valor * peso);
                peso++;
                if (peso == 10) {
                    peso = 2;
                }
            }
            resto = valorComPeso % 11;
            if ((resto == 0) || (resto == 1)) {
                ver1 = '0';
            } else {
                ver1 = (char) ((11-resto) + 48);
            }

            // SEGUNDO DIGITO VERIFICADOR
            valorComPeso = 0;
            peso = 2;
            for (int i = 12; i >= 0; i--) {
                valor = Character.getNumericValue(cnpj.charAt(i));
                valorComPeso = valorComPeso + (valor * peso);
                peso++;
                if(peso == 10) {
                    peso = 2;
                }
            }
            resto = valorComPeso % 11;
            if((resto == 0) || (resto == 1)) {
                ver2 = '0';
            } else {
                ver2 = (char) ((11-resto) + 48);
            }

            //CONFERE OS VERIFICADORES
            return (ver1 == cnpj.charAt(12)) && (ver2 == cnpj.charAt(13));
        }
    }

    public default String inserirPontuacaoCpf(String cpf) {
        return cpf.substring(0,3) + "." + cpf.substring(3,6) + "." + cpf.substring(6,9) + "-" + cpf.substring(9,11);
    }

    public default String removerPontuacaoCpf(String cpf) {
        return cpf.replace(".","").replace("-","");
    }

    public default String removerPontuacaoCnpj(String cnpj) {
        return cnpj.replace(".","").replace("-","").replace("/", "");
    }

    public default String inserirPontuacaoCnpj(String cnpj) {
        return cnpj.substring(0,2) + "." + cnpj.substring(2,5) + "." + cnpj.substring(5,8) + "/" + cnpj.substring(8,12) + "-" + cnpj.substring(12,14);
    }

    public default boolean validarEmail(String email) {
        String regex = "^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+$";
        Pattern padrao = Pattern.compile(regex);
        Matcher comparador = padrao.matcher(email);
        return comparador.matches();
    }

    public default boolean validarSenha(String senha) {
        String regex = "^(?=.*\\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,}$";
        Pattern padrao = Pattern.compile(regex);
        Matcher comparador = padrao.matcher(senha);
        return comparador.matches();
    }

}