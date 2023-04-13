package dio.web.api.repository;

import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    public void save(Usuario usuario){
        if (usuario.getId()==null)
            System.out.println("Save - Recebendo o usuário na camada de repositório");
        else
            System.out.println("Update - Recebendo o usuário na camada de repositório");

            System.out.println(usuario);
    }

    public void deleteById(Integer id){
        System.out.println(String.format("Delete/id: %d para excluir um usu[ario", id));
        System.out.println(id);
    }

    public List<Usuario> findAll(){
        System.out.println("List - Listando os usuários do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("alcides", "password"));
        usuarios.add(new Usuario("alcides", "masterpassword"));
        return usuarios;
    }

    public Usuario findById(Integer id){
        System.out.println(String.format("Find/id - Recebendo o id:  %d para localizar um usuário", id));
        return new Usuario("alcides", "password");
    }

    public Usuario findByUsername(String username){
        System.out.println(String.format("Find/username - Recebendo o username:  %d para localizar um usuário", username));
        return new Usuario("alcides", "password");
    }
}
