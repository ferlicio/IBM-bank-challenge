import { Component, OnInit} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialog } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { ElementActionDialogComponent } from 'src/app/widget/ait-table/element-action-dialog/element-action-dialog.component';
import { Movimentacao, eColunaXPropMovimentacao } from 'src/shared/models/movimentacao';
import { ScreenSizeService } from 'src/shared/services/screen-size.service';

@Component({
  selector: 'app-listar-Movimentacoes',
  templateUrl: './listar-Movimentacoes.component.html',
  styleUrls: ['./listar-Movimentacoes.component.scss']
})
export class ListarMovimentacoesComponent {

  screenSize!: string;
  Movimentacoes: Movimentacao[] = [

  ]
  colunasVisiveis: string[] = ['Nome', 'CNPJ', 'Email', 'Website', 'Telefone', 'Area de atuação'];
  todasColunas: string[] = [...this.colunasVisiveis, 'Tipo', 'Contato'];
  colunaXPropriedade = eColunaXPropMovimentacao; 

  filtroEPesquisa: FormGroup = this.fb.group({
    filtro: [''],
    pesquisa: ['']
  })
  
  constructor(private screenSizeService: ScreenSizeService, private fb: FormBuilder, private router: Router, private dialog: MatDialog) { }

  ngOnInit(): void {   
    this.screenSizeService.screenSize().subscribe(size => {
      this.screenSize = size;
    }); 
  }

  editEl(id: number) {
    this.router.navigate(['/Movimentacoes/editar'],
    {queryParams: {id: id}})
  }

  deleteEl(id: number) {
    const dialogRef = this.dialog.open(ElementActionDialogComponent, {
      data: {id: id, title: 'Excluir movimentacao', message: 'Você deseja mesmo excluir o movimentacao selecionado?'}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) { console.log(`movimentacao a ser deletado: ${result}`);}
    })
  }
}
