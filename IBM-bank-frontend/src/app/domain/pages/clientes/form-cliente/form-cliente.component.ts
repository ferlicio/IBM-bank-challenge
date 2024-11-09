import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { ClienteApiService } from 'src/app/core/services/api/cliente/cliente.api.service';
import { FormField, TableFormFields } from 'src/app/widget/ait-form/ait-form.component';
import { CNAE, classeDoGrupo, estado, grupoDoCNAE } from 'src/shared/models/dadosIBGE';
import { ibgeService } from 'src/shared/services/ibge.service';
import { ValidacoesService } from 'src/shared/services/validacoes.service';

@Component({
  selector: 'app-form-cliente',
  templateUrl: './form-cliente.component.html',
  styleUrls: ['./form-cliente.component.scss'],
})
export class FormClienteComponent implements OnInit{

  constructor(
    private fb: FormBuilder, private router:Router, 
    private _snackBar: MatSnackBar, private clienteApiService: ClienteApiService,
    private route: ActivatedRoute,
  ) { }

  fieldsClientePrincipal: TableFormFields = [
    [
      { name: 'Categorias de Atividade', type: 'select', formControlName: 'categoriaAtividade', fieldWidth: '100%'},
      { name: 'Grupo de Atividade', type: 'select', formControlName: 'grupoDeAtividade', fieldWidth: '100%'},
      { name: 'Sub-Categoria', type: 'select', formControlName: 'subCategoria', fieldWidth: '100%'},
    ],[
      { name: 'Tipo de Pessoa', type: 'select', formControlName: 'tipoPessoa', fieldFlexGrow:1, options: [['Física','F'],['Jurídica','J']]},
      { name: 'Data de Cadastro', type: 'date', formControlName: 'dataCadastro', fieldFlexGrow:1 },
    ],[
    ],
  ]

  fieldsClienteEndereco: TableFormFields = [
    [
      { name: 'CEP', type: 'text', formControlName: 'cep', fieldWidth: '49%',validators: {maskPattern: '00000-000'}},
    ],[
      { name: 'Estado', type: 'select', formControlName: 'estado', fieldFlexGrow: 1, options:[]},
      { name: 'Cidade', type: 'select', formControlName: 'cidade', fieldFlexGrow: 1, options:[]},
    ],[
      { name: 'Logradouro', type: 'text', formControlName: 'logradouro', fieldWidth: '100%'},
      { name: 'Bairro', type: 'text', formControlName: 'bairro', fieldFlexGrow: 10},
      { name: 'Número', type: 'number', formControlName: 'numero', fieldFlexGrow: 1},
      { name: 'Complemento', type: 'text', formControlName: 'complemento', fieldFlexGrow: 2},
    ]
  ]
  fieldsClienteContato: TableFormFields = [
    [
      { name: 'Telefone 1', type: 'text', formControlName: 'telefone1', fieldFlexGrow: 1,validators: {maskPattern: '(00) 0000-0000||(00) 00000-0000'}},
      { name: 'Telefone 2', type: 'text', formControlName: 'telefone2', fieldFlexGrow: 1,validators: {maskPattern: '(00) 0000-0000||(00) 00000-0000'}},
    ],
    [
      { name: 'Site', type: 'text', formControlName: 'site', fieldFlexGrow: 3},
      { name: 'E-mail', type: 'text', formControlName: 'email', fieldFlexGrow: 4},
    ]
  ]

  formClienteFisica = this.fb.group({
    nome: [''],
    cpf: ['']
  });

  formCliente = this.fb.group({
    tipoPessoa: ['',Validators.required],
    ...this.formClienteFisica.controls,
    //endereço
    cep: ['',[Validators.required, Validators.minLength(8), Validators.maxLength(8)]],
    logradouro: ['',[Validators.required]],
    numero: ['',[Validators.required]],
    complemento: [''],
    bairro: ['',[Validators.required]],
    cidade: ['',[Validators.required]],
    estado: ['',[Validators.required]],
    //contato
    site: [''],
    email: ['',],
    telefone1: ['', [Validators.required]],
    telefone2: [''],
  })

  queryParams: any;
  isEditing: boolean = false;

  ngOnInit(): void {
    this.route.url.subscribe(url => {
      if (url[0].path == 'editar') {
        this.formCliente.disable()
        this.route.queryParams.subscribe(params => {
          this.queryParams = params;
        })
      }
    })
  }

  salvarCliente() {
    console.log(this.formCliente.value);
    this._snackBar.open("Cliente "+ (this.isEditing?"editado":"salvo") +" com sucesso", "fechar", {duration: 5000, panelClass: ['snackbar-success'], horizontalPosition: 'end'});
    this.router.navigate(['/clientes']);
  }
  editarCliente() {
    this.isEditing = true;
    this.formCliente.enable();
    this.formCliente.controls['cpf'].disable();
  }
}
